package hanhnd.tbl_Tours;

import hanhnd.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tbl_ToursDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (psmt != null) {
            psmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<Tbl_ToursDTO> searchByCategory(int ID) throws Exception {

        List<Tbl_ToursDTO> list = null;
        try {
            String sql = "Select Id, Name, Price, Description, StartDate, EndDate, ParticipantNumber, MaxParticipantNumber, CategoryId, Status, Image "
                    + "FROM tbl_Tours WHERE Status = 'valid' AND (MaxParticipantNumber-ParticipantNumber) > 0 AND (StartDate > (SELECT GETDATE())) AND tbl_Tours.CategoryId LIKE (SELECT Id FROM tbl_Category WHERE Id LIKE ?)";
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setInt(1, ID);
                rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    String id = rs.getString("Id");
                    String name = rs.getString("Name");
                    String price = rs.getString("Price");
                    String description = rs.getString("Description");
                    String startDate = rs.getString("StartDate");
                    String endDate = rs.getString("EndDate");
                    String participantNumber = rs.getString("ParticipantNumber");
                    String maxParticipantNumber = rs.getString("MaxParticipantNumber");
                    String categoryId = rs.getString("CategoryId");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    Tbl_ToursDTO dto = new Tbl_ToursDTO(Integer.valueOf(id), name, Float.valueOf(price), description, startDate, endDate, Integer.valueOf(participantNumber), Integer.valueOf(maxParticipantNumber), Integer.valueOf(categoryId), status, image);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<Tbl_ToursDTO> searchByPrice(float min, float max) throws Exception {
        List<Tbl_ToursDTO> list = null;
        try {
            String sql = "Select Id, Name, Price, Description, StartDate, EndDate, ParticipantNumber, MaxParticipantNumber, CategoryId, Status, Image "
                    + "FROM tbl_Tours WHERE Price between ? and ? ORDER BY Price ASC";
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setFloat(1, min);
                psmt.setFloat(2, max);
                rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    String id = rs.getString("Id");
                    String name = rs.getString("Name");
                    String price = rs.getString("Price");
                    String description = rs.getString("Description");
                    String startDate = rs.getString("StartDate");
                    String endDate = rs.getString("EndDate");
                    String participantNumber = rs.getString("ParticipantNumber");
                    String maxParticipantNumber = rs.getString("MaxParticipantNumber");
                    String categoryId = rs.getString("CategoryId");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    Tbl_ToursDTO dto = new Tbl_ToursDTO(Integer.valueOf(id), name, Float.valueOf(price), description, startDate, endDate, Integer.valueOf(participantNumber), Integer.valueOf(maxParticipantNumber), Integer.valueOf(categoryId), status, image);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public Tbl_ToursDTO searchByID(int id) throws Exception {
        Tbl_ToursDTO dto = null;
        try {
            String sql = "Select Id, Name, Price, Description, StartDate, EndDate, ParticipantNumber, MaxParticipantNumber, CategoryId, Status, Image "
                    + "FROM tbl_Tours WHERE Id = ?";
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setInt(1, id);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    String description = rs.getString("Description");
                    String startDate = rs.getString("StartDate");
                    String endDate = rs.getString("EndDate");
                    int participantNumber = rs.getInt("ParticipantNumber");
                    int maxParticipantNumber = rs.getInt("MaxParticipantNumber");
                    int categoryId = rs.getInt("categoryId");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    dto = new Tbl_ToursDTO(id, name, price, description, startDate, endDate, participantNumber, maxParticipantNumber, categoryId, status, image);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean updateParticipantNumber(int ID, int number) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tbl_Tours set ParticipantNumber = ParticipantNumber + ? WHERE Id = ?";
            conn = MyConnection.getMyConnection();
            if(conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setInt(1, number);
                psmt.setInt(2, ID);
                check = psmt.executeUpdate() > 0;
            } 
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateStatus(int ID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tbl_Tours set Status = 'invalid' WHERE Id = ?";
            conn = MyConnection.getMyConnection();
            if(conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setInt(1, ID);
                check = psmt.executeUpdate() > 0;
            } 
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateTour(Tbl_ToursDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tbl_Tours set Name = ?, Price = ?, Description = ?, StartDate = ?, EndDate = ?, ParticipantNumber = ?, MaxParticipantNumber = ?, CategoryId = ?, Status = ?, Image = ? WHERE Id = ?";
            conn = MyConnection.getMyConnection();
            if(conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, dto.getName());
                psmt.setFloat(2, dto.getPrice());
                psmt.setString(3, dto.getDescription());
                psmt.setString(4, dto.getStartDate());
                psmt.setString(5, dto.getEndDate());
                psmt.setInt(6, dto.getParticipantNumber());
                psmt.setInt(7, dto.getMaxParticipantNumber());
                psmt.setInt(8, dto.getCategoryId());
                psmt.setString(9, dto.getStatus());
                psmt.setString(10, dto.getImage());
                psmt.setInt(11, dto.getId());
                check = psmt.executeUpdate() > 0;
            } 
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insertTour(Tbl_ToursDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO tbl_Tours (Name,Price,Description,StartDate,EndDate,ParticipantNumber,MaxParticipantNumber,CategoryId,Status,Image) values(?,?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            if(conn != null) {
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, dto.getName());
                psmt.setFloat(2, dto.getPrice());
                psmt.setString(3, dto.getDescription());
                psmt.setString(4, dto.getStartDate());
                psmt.setString(5, dto.getEndDate());
                psmt.setInt(6, dto.getParticipantNumber());
                psmt.setInt(7, dto.getMaxParticipantNumber());
                psmt.setInt(8, dto.getCategoryId());
                psmt.setString(9, dto.getStatus());
                psmt.setString(10, dto.getImage());
                check = psmt.executeUpdate() > 0;
            } 
        } finally {
            closeConnection();
        }
        return check;
    }
    
   public List<Tbl_ToursDTO> getListTour() throws Exception {
        List<Tbl_ToursDTO> list = null;
        try {
            String sql = "Select Id, Name, Price, Description, StartDate, EndDate, ParticipantNumber, MaxParticipantNumber, CategoryId, Status, Image FROM tbl_Tours Where Status = 'valid'";
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                psmt = conn.prepareStatement(sql);
                rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    String description = rs.getString("Description");
                    String startDate = rs.getString("StartDate");
                    String endDate = rs.getString("EndDate");
                    int participantNumber = rs.getInt("ParticipantNumber");
                    int maxParticipantNumber = rs.getInt("MaxParticipantNumber");
                    int categoryId = rs.getInt("CategoryId");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    Tbl_ToursDTO dto = new Tbl_ToursDTO(id, name, price, description, startDate, endDate, participantNumber, maxParticipantNumber, categoryId, status, image);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
   
}
