package com.controller;

import com.dao.UserDAO;
import com.model.Users;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 26.01.17.
 */

@Controller
public class UserController {

    // TODO: 26.01.17 userservice - userDao - abstractDao - EM

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/register-user")
    @ExceptionHandler({Exception.class})
    public String registerUser(HttpSession session, @ModelAttribute Users user) throws Exception {

        Users existingUser = userService.getByEmail(user.getEmail());
        if (existingUser != null)
            throw new Exception("User exist");

        try {
            Users users = userService.register(user);
            if (user == null)
                throw new Exception();
        } catch (Exception e) {
            throw new Exception("Server error. Try again later, please!");
        }

        Users.setCurrent(session, user);
        return "redirect:/";


        // check if exist - error - 400
        // if no - register - 200

        String result = userService.register(user);

        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("result", result);
        modelAndView.addObject("user", user);
        modelAndView.addObject("state", "registered");

        user.setCurrent(session, user);

        return null;
        // TODO: 13.02.17  
    }


    @RequestMapping("/login-request")
    public ResponseEntity<String> loginRequest(HttpSession session, @RequestParam String email, @RequestParam String password){

        // check if not exist - error - 400
        // if no - register - 200

        // Users curUser = userService


        return null;

    }

    @RequestMapping("/log-out-request")
    public ResponseEntity<String> loginRequest(HttpSession session){

        Users.setCurrent(session, null);


//        return new ResponseEntity<>(HttpStatus.OK);


        return null;

    }

}
