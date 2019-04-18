package hanhnd.tbl_Categories;

import hanhnd.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tbl_CategoriesDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    
    private void closeConnection() throws Exception{
        if(rs != null) {
            rs.close();
        } if(psmt != null) {
            psmt.close();
        } if(conn != null) {
            conn.close();
        }
    }
    
    public List<Tbl_CategoryDTO> getListCategory() throws Exception {
        List<Tbl_CategoryDTO> list = null;
        try {
            String sql = "SELECT Id, Name, Description, Status, Image FROM tbl_Category";
            conn = MyConnection.getMyConnection();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                String image = rs.getString("Image");
                Tbl_CategoryDTO dto = new Tbl_CategoryDTO(id, name, description, status, image);
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    
}
