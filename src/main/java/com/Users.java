package com;

import java.util.Date;
import java.util.List;

public class Users {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Long isPhoneVerified;
    private Long isEmailVerified;
    private Date dateOfBirth;
    private String city;

    //one - to - many
    private List<Ad> adsPublished;
    //one - to - many - //AD_ID
    private List<Ad> adsJoined;
    private String rating;

    //one - to -  many //USERS_ID
    private List<FriendRelation> friends;

    private Date lastLogin;
    private Date dateRegistered;

    //this filed is not stored in db
    //private boolean isLogged;

    private Long isActive;
    private String attributes;

    public Users() {
    }

    public Users(String firstName, String lastName, String phone, String email, Date dateOfBirth, String city) {
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

    //public static void main(String[] args) {
    //    double d = Double.parseDouble(rating);
    //}

}
