package hanhnd.tbl_Tours;

import java.io.Serializable;

public class Tbl_ToursDTO implements Serializable {
    private int id;
    private String name;
    private float price;
    private String description;
    private String startDate;
    private String endDate;
    private int participantNumber;
    private int maxParticipantNumber;
    private int categoryId;
    private String status;
    private String image;
    
    public Tbl_ToursDTO() {
    }

    public Tbl_ToursDTO(int id, String name, float price, String description, String startDate, String endDate, int participantNumber, int maxParticipantNumber, int categoryId, String status, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantNumber = participantNumber;
        this.maxParticipantNumber = maxParticipantNumber;
        this.categoryId = categoryId;
        this.status = status;
        this.image = image;
    }
    
    public Tbl_ToursDTO(String name, float price, String description, String startDate, String endDate, int participantNumber, int maxParticipantNumber, int categoryId, String status, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantNumber = participantNumber;
        this.maxParticipantNumber = maxParticipantNumber;
        this.categoryId = categoryId;
        this.status = status;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public int getMaxParticipantNumber() {
        return maxParticipantNumber;
    }

    public void setMaxParticipantNumber(int maxParticipantNumber) {
        this.maxParticipantNumber = maxParticipantNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
