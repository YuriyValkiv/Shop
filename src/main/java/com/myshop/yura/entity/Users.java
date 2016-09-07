package com.myshop.yura.entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_id")
    private long id;

    @Column(name = "users_name")
    private String name;

    @Column(name = "users_email")
    private String email;

    @Column(name = "users_country")
    private String country;

    @Column(name = "users_city")
    private String city;

    @Column(name = "users_password")
    private String password;

    @Column(name = "users_role")
    private String role;

    public Users() {}

    public Users(String name, String email, String country, String city, String password, String role) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.password = password;
        this.role = role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
