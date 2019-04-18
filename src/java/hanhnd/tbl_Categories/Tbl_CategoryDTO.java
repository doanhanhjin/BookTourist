package hanhnd.tbl_Categories;

import java.io.Serializable;

public class Tbl_CategoryDTO implements Serializable{
    private int id;
    private String name, description, status, image;

    public Tbl_CategoryDTO() {
    }

    public Tbl_CategoryDTO(int id, String name, String description, String status, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.image = image;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
