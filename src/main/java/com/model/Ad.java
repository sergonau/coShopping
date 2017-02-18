package com.model;


import com.dao.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//TODO create new db
//TODO create table in db
//TODO move to hibernate
//TODO create test page to display test ad


public class Ad extends BaseEntity{
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
    private Users participants;

    public Ad(String itemName, Integer totalPrice, String city, Date dateExpires, Date dateCreated, Users owner) {
        this.itemName = itemName;
        this.totalPrice = totalPrice;
        this.city = city;
        this.dateExpires = dateExpires;
        this.dateCreated = new Date();
        this.owner = owner;

        this.isActive = 1;
    }


    @Id
    @SequenceGenerator(name = "TEST_SEQ", sequenceName = "AD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "ITEM_NAME")
    public String getItemName() {
        return itemName;
    }

    @Column(name = "TOTAL_PRICE")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "DATE_EXPIRES")
    public Date getDateExpires() {
        return dateExpires;
    }

    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    @Column(name = "DATE_EDITED")
    public Date getDateEdited() {
        return dateEdited;
    }

    @Column(name = "IS_ACTIVE")
    public Integer getIsActive() {
        return isActive;
    }

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    public Users getOwner() {
        return owner;
    }

    @ManyToOne
    @JoinColumn(name = "PARTICIPANTS_ID")
    public Users getParticipants() {
        return participants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateEdited(Date dateEdited) {
        this.dateEdited = dateEdited;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public void setParticipants(Users participants) {
        this.participants = participants;
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
