package com.model;

import com.dao.BaseEntity;
import sun.rmi.runtime.Log;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

// / TODO: 22.01.17 создать таблицы в базе (3 шт), сделать маппинг таблиц и классов с помощью аннотаций

public class Users extends BaseEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Long isPhoneVerified;
    private Long isEmailVerified;
    private Date dateOfBirth;
    private String city;
    private String rating;
    private Date lastLogin;
    private Date dateRegistered;
    private Long isActive;
    private String attributes;

    //one - to - many
    private List<Ad> adsPublished;
    //one - to - many - //AD_ID
    private List<Ad> adsJoined;


    //one - to -  many //USERS_ID
    private List<FriendRelation> friends;


    //this filed is not stored in db
    //private boolean isLogged;



    public Users() {
    }

    public Users(Long id, String firstName, String lastName, String phone, String email, String password, Date dateOfBirth, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.city = city;

        this.lastLogin = new Date();
        this.dateRegistered = new Date();
        this.isActive = 1L;
        //this.isLogged = false;
        this.isEmailVerified = 0L;
        this.isPhoneVerified = 0L;
    }

    @Id
    @SequenceGenerator(name = "TEST_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }


    @Column(name = "IS_PHONE_VERIFIED")
    public Long getIsPhoneVerified() {
        return isPhoneVerified;
    }

    @Column(name = "IS_EMAIL_VERIFIED")
    public Long getIsEmailVerified() {
        return isEmailVerified;
    }


    @Column(name = "IS_EMAIL_VERIFIED")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }


    public String getRating() {
        return rating;
    }

    public Date getLastLogin() {
        return lastLogin;
    }


    public Date getDateRegistered() {
        return dateRegistered;
    }

    public Long getIsActive() {
        return isActive;
    }

    public String getAttributes() {
        return attributes;
    }

    @OneToMany(targetEntity = Ad.class, mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Ad> getAdsPublished() {
        return adsPublished;
    }

    @OneToMany(targetEntity = Ad.class, mappedBy = "participants", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Ad> getAdsJoined() {
        return adsJoined;
    }

    public static void setCurrent(HttpSession session, Users curUser){
        session.setAttribute("logged", curUser);
    }

    public static Users current(HttpSession session, Users curUser){
        return (Users) session.getAttribute("logged");
    }


    //public static void main(String[] args) {
    //    double d = Double.parseDouble(rating);
    //}

}
