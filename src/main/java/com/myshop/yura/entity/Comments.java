package com.myshop.yura.entity;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comments_id")
    private long id;

    @Column(name = "comments_author")
    private String author;

    @Column(name = "comments_date")
    private String date;

    @Column(name = "comments_comment")
    private String comment;

    @Column(name = "lot_name")
    private String lot_name;

    @Column(name = "comments_stars")
    private byte stars;

    public Comments() {}

    public Comments(String author, String date, String comment, String lot_name) {
        this.author = author;
        this.date = date;
        this.comment = comment;
        this.lot_name = lot_name;
        //this.stars = stars;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setLot_name(String lot_name) {
        this.lot_name = lot_name;
    }

    public String getLot_name() {
        return lot_name;
    }

    public void setStars(byte stars) {
        this.stars = stars;
    }

    public byte getStars() {
        return stars;
    }
}
