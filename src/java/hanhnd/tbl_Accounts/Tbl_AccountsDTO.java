package hanhnd.tbl_Accounts;

import java.io.Serializable;

public class Tbl_AccountsDTO implements Serializable{
    private String username, password, fullname, role, address, email, phoneNumber;
    private boolean gender, status;

    public Tbl_AccountsDTO() {
    }

    public Tbl_AccountsDTO(String fullname, String role) {
        this.fullname = fullname;
        this.role = role;
    }

    public Tbl_AccountsDTO(String username, String password, String fullname, String role, String address, String email, String phoneNumber, boolean gender, boolean status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.status = status;
    }

    
    public Tbl_AccountsDTO(String username, String fullname, String role, String address, String email, boolean gender, String phoneNumber, boolean status) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
