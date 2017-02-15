package com.dao;

import com.model.Users;

import java.util.List;

public interface UserDAO {
    Users saveUser(Users user);

    //Users updateUser(Users user);

    Users getByEmail(String email);

    Users getByEmailAndPassword(String email, String password);
}
