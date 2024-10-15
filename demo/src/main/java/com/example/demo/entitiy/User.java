package com.example.demo.entitiy;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userFullName;
    private String userEmail;
    private String userPassword;

    // Basket alanı kaldırıldı

    public User() {
    }

    public User(int id, String userFullName, String userEmail, String userPassword) {
        this.id = id;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    // Getter ve Setter'lar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserfullname(String username) {

    }

    public void setUseremail(String email) {

    }

    public void setUserpassword(String password) {

    }

    public String getUserfullname() {
        return null;
    }
}




