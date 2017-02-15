package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 20.01.17.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("index.vm");
        modelAndView.addObject("name", "Sergey");
        return modelAndView;
    }
}