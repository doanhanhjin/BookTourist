package hanhnd.tbl_Orders;

import java.io.Serializable;

public class Tbl_OrdersDTO implements Serializable{
    private int id, tourId, quantity;
    private float total;
    private String username, status, checkoutDate;;

    public Tbl_OrdersDTO() {
    }

    
    public Tbl_OrdersDTO(float total, String username, String status, String checkoutDate, int tourId, int quantity) {
        this.total = total;
        this.username = username;
        this.status = status;
        this.checkoutDate = checkoutDate;
        this.tourId = tourId;
        this.quantity = quantity;
    }

    public Tbl_OrdersDTO(int id, float total, String username, String status, String checkoutDate) {
        this.id = id;
        this.total = total;
        this.username = username;
        this.status = status;
        this.checkoutDate = checkoutDate;
    }

    public Tbl_OrdersDTO(int id, int tourId, int quantity, float total, String username, String status, String checkoutDate) {
        this.id = id;
        this.tourId = tourId;
        this.quantity = quantity;
        this.total = total;
        this.username = username;
        this.status = status;
        this.checkoutDate = checkoutDate;
    }

    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

  
    
    
}
