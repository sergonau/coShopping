package com;


import java.util.Date;
import java.util.List;
import java.util.Locale;

//TODO create new db
//TODO create table in db
//TODO move to hibernate
//TODO create test page to display test ad


public class Ad {
    private Long id;
    private String itemName;
    private Integer totalPrice;
    private String city;
    private Date dateExpires;
    private Date dateCreated;
    private Date dateEdited;
    private Integer isActive;

    //many-to-one
    private Users owner;
    //many-to-one
    private List<Users> participants;

    public Ad(String itemName, Integer totalPrice, String city, Date dateExpires, Date dateCreated, Users owner) {
        this.itemName = itemName;
        this.totalPrice = totalPrice;
        this.city = city;
        this.dateExpires = dateExpires;
        this.dateCreated = new Date();
        this.owner = owner;

        this.isActive = 1;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getCity() {
        return city;
    }

    public Date getDateExpires() {
        return dateExpires;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateEdited() {
        return dateEdited;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public Users getOwner() {
        return owner;
    }

    public List<Users> getParticipants() {
        return participants;
    }

    //create new project from scratch
    //use the same spring configs as in old one
    //use the same maven - pom, jsut change project name
    //build with maven
    //run server tomcat
    //you should see welcome page

    //create aws rds instance - oracle db
    //connect project to it in config

    //create table users in db
    //map users table to users class




}
