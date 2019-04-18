package hanhnd.tbl_Accounts;

import hanhnd.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tbl_AccountsDAO implements Serializable {

    private Connection conn;
    private PreparedStatement psmt;
    private ResultSet rs;

    public Tbl_AccountsDAO() {
    }

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

    public Tbl_AccountsDTO checkLogin(String username, String password) throws Exception {
        Tbl_AccountsDTO dto = null;
        try {
            String sql = "Select Username, Password, Fullname, Role, Address, Email, Gender_IsMale, PhoneNumber, Status from tbl_Accounts Where Username = ? and Password = ?";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                boolean gender = rs.getBoolean("Gender_IsMale");
                String phone = rs.getString("PhoneNumber");
                boolean status = rs.getBoolean("Status");
                dto = new Tbl_AccountsDTO(username, password, fullname, role, address, email, phone, gender, status);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insertAccount(Tbl_AccountsDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into tbl_Accounts(Username, Password, Fullname, Role, Address, Email, Gender_IsMale, PhoneNumber, Status)"
                    + " values(?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getUsername());
            psmt.setString(2, dto.getPassword());
            psmt.setString(3, dto.getFullname());
            psmt.setString(4, dto.getRole());
            psmt.setString(5, dto.getAddress());
            psmt.setString(6, dto.getEmail());
            psmt.setBoolean(7, dto.isGender());
            psmt.setString(8, dto.getPhoneNumber());
            psmt.setBoolean(9, dto.isStatus());
            check = psmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<Tbl_AccountsDTO> getListAccount() throws Exception {
        List<Tbl_AccountsDTO> list = null;
        try {
            String sql = "SELECT Username, Password, Fullname, Role, Address, Email, Gender_IsMale, PhoneNumber, Status from tbl_Accounts";
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                psmt = conn.prepareStatement(sql);
                rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String fullname = rs.getString("Fullname");
                    String role = rs.getString("Role");
                    String address = rs.getString("Address");
                    String email = rs.getString("Email");
                    boolean gender = rs.getBoolean("Gender_IsMale");
                    String phone = rs.getString("PhoneNumber");
                    boolean status = rs.getBoolean("Status");
                    Tbl_AccountsDTO dto = new Tbl_AccountsDTO(username, password, fullname, role, address, email, phone, gender, status);
                    
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean updateAccount(Tbl_AccountsDTO dto) throws Exception  {
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Accounts set Password = ?, Fullname = ?, Address = ?, Email = ?, Gender_IsMale = ?, PhoneNumber = ?  WHERE Username = ?";
            System.out.println("DAO1");
            conn = MyConnection.getMyConnection();
            if(conn != null) {
                 System.out.println("DAO2");
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, dto.getPassword());
                psmt.setString(2, dto.getFullname());
                psmt.setString(3, dto.getAddress());
                psmt.setString(4, dto.getEmail());
                psmt.setBoolean(5, dto.isGender());
                psmt.setString(6, dto.getPhoneNumber());
                psmt.setString(7, dto.getUsername());
                check = psmt.executeUpdate() > 0;
                 System.out.println("DAO3");
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
