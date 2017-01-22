package com;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by andrii on 1/15/17.
 */
//table
public class FriendRelation {
    private Long userFromId; //many-to-one to Users table
    private Long userToId;
    private Date dateCreated;

    //@ManyToOne
    //@JoinColumn(name = "TO_TASK_ID")

    //@OneToMany(targetEntity = CodeComments.class, mappedBy = "solution", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
}