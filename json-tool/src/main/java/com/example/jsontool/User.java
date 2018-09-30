package com.example.jsontool;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2018-09-30
 **/
public class User implements Serializable {

    private int id;

    private String name = "";

    private String gender = "";

    private String phoneNumber = "";

    private String email = "";

    private Date createdTime;

    public User() {
    }

    public User(int id, String name, String gender, String phoneNumber, String email, Date createdTime) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createdTime = createdTime;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User getInstance(int id, String name, String gender, String phoneNumber, String email, Date createdTime) {
        User user = new User(id, name, gender, phoneNumber, email, createdTime);
        return user;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
