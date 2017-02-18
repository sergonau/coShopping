package com.service;

import com.model.Users;

public interface UserService {

    // TODO: 13.02.17 Ad DAO, Ad DAOImpl, Ad Service, Ad ServiceImpl

    Users saveUser(Users user);

    String register(Users users);

    Users getByEmail(String email);

   /* List<User> getAll();

    User get(String name, String psw);

    void clean();

    User makeInactive(User user);

    User login(String userName, String psw);

    User logout(User user);

    void addToFriend() throws Exception;*/
}
