package com.myshop.yura.entity;

import javax.persistence.*;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "cart_name")
    private String name;

    @Column(name = "cart_price")
    private double price;

    @Column(name = "cart_image")
    private String image;

    @Column(name = "cart_user")
    private String user;

    public ShoppingCart(){}

    public ShoppingCart(String name, double price, String image, String user) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.user = user;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
