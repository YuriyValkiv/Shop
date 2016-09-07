package com.myshop.yura.entity;

import javax.persistence.*;

@Entity
@Table(name = "Lot")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lot_id")
    private long id;

    @Column(name = "lot_name")
    private String name;

    @Column(name = "lot_type")
    private String type;

    @Column(name = "lot_price")
    private double price;

    @Column(name = "lot_country")
    private String country;

    @Column(name = "lot_image")
    private String image;

    @Column(name = "lot_imageBig")
    private String imageBig;

    @Column(name = "lot_description")
    private String description;

    @Column(name = "lot_descriptionBig")
    private String descriptionBig;

    public Lot() {}

    public Lot(String name, String type, double price, String country, String image, String imageBig, String description, String descriptionBig) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.country = country;
        this.image = image;
        this.imageBig = imageBig;
        this.description = description;
        this.descriptionBig = descriptionBig;
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescriptionBig(String descriptionBig) {
        this.descriptionBig = descriptionBig;
    }

    public String getDescriptionBig() {
        return descriptionBig;
    }
}
