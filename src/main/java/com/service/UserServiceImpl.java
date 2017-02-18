package com.service;

import com.dao.UserDAO;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Users saveUser(Users user) {
        return userDAO.saveUser(user);
    }

    @Override
    public String register(Users user) {
        Users users = userDAO.getByEmail(user.getEmail());

        if (users != null)
            return "User with this email is registered";

        userDAO.saveUser(user);
        return null;
    }

    @Override
    public Users getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    /* @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User get(String name, String psw) {
        return userDAO.get(name, psw);
    }

    @Override
    public void clean() {
        userDAO.clean();

    }

    @Override
    public User login(String userName, String psw) {
        //business logic
        User curUser = userDAO.get(userName, psw);

        if (curUser != null) {
            curUser.setLogged(true);
            userDAO.updateUser(curUser);
        }

        return curUser;
    }

    @Override
    public User logout(User user) {
        user.setLogged(false);
        userDAO.updateUser(user);
        return user;
    }

    @Override
    public User makeInactive(User user) {
        user.setActive(false);
        userDAO.updateUser(user);
        return user;
    }

    public void addToFriend() throws Exception {
        //test data create here
        List<User> userList = userDAO.getAll();
        User fromUser = userList.get(0);
        User toUser = userList.get(1);
        //

        if (!fromUser.isLogged()) throw new Exception("you are is not logged in");

        fromUser.getFriends().add(toUser);
        toUser.getFriends().add(fromUser);
    }*/
}
