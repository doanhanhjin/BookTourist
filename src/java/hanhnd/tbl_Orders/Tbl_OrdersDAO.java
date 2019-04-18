package hanhnd.tbl_Orders;

import hanhnd.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tbl_OrdersDAO implements Serializable{
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
    
    public List<Tbl_OrdersDTO> getListOrder() throws Exception {
        List<Tbl_OrdersDTO> list = null;
        try {
            String sql = "SELECT Id, CheckoutDate, Total, Username, Status FROM tbl_Orders";
             conn = MyConnection.getMyConnection();
             if(conn != null) {
                 psmt = conn.prepareStatement(sql);
                 rs = psmt.executeQuery();
                 while(rs.next()) {
                     int id = rs.getInt("Id");
                     String checkoutDate = rs.getString("CheckoutDate");
                     float total = rs.getFloat("Total");
                     String username = rs.getString("Username");
                     String status = rs.getString("Status");
                     Tbl_OrdersDTO dto = new Tbl_OrdersDTO(id, total, username, status, checkoutDate);
                     list = new ArrayList<>();
                     list.add(dto);
                 }
             }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean insertOrder(Tbl_OrdersDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO tbl_Orders (CheckOutDate, Total, Username, Status, TourId, Quantity) values(?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getCheckoutDate());
            psmt.setFloat(2, dto.getTotal());
            psmt.setString(3, dto.getUsername());
            psmt.setString(4, dto.getStatus());
            psmt.setInt(5, dto.getTourId());
            psmt.setInt(6, dto.getQuantity());
            check = psmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int getId(Tbl_OrdersDTO dto) throws Exception {
        int id = 0;
        try {
            String sql = "SELECT Id FROM tbl_Orders WHERE CheckOutDate = ? AND Total = ? AND Username = ? AND Status = ? AND TourId = ?";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getCheckoutDate());
            psmt.setFloat(2, dto.getTotal());
            psmt.setString(3, dto.getUsername());
            psmt.setString(4, dto.getStatus());
            psmt.setInt(5, dto.getTourId());
            rs = psmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt("Id");
            }
        } finally {
            closeConnection();
        }
        return id;
    }
    public int getTourId(int id) throws Exception {
        int tourId = 0;
        try {
            String sql = "SELECT TourId FROM tbl_Orders WHERE Id = ?";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if(rs.next()) {
                tourId = rs.getInt("TourId");
            }
        } finally {
            closeConnection();
        }
        return tourId;
    }
    
    public List<Tbl_OrdersDTO> getOrderByUsername(String username) throws Exception {
        List<Tbl_OrdersDTO> list = null;
        try {
            String sql = "SELECT Id, CheckoutDate, Total, Username, Status, TourId, Quantity FROM tbl_Orders WHERE Username = ? AND Status like 'available'";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            rs = psmt.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("Id");
                String checkoutDate = rs.getString("CheckoutDate");
                float total = rs.getFloat("Total");
                int tourId = rs.getInt("TourId");
                String status = rs.getString("Status");
                int quantity = rs.getInt("Quantity");
                Tbl_OrdersDTO dto = new Tbl_OrdersDTO(id, tourId, quantity, total, username, status, checkoutDate);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean updateStatus(int id) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Orders SET Status = 'notavailable' WHERE Id = ?";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            check = psmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
