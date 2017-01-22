package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 20.01.17.
 */

@Controller
public class Test {

    @RequestMapping(value = "/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("index.vm");

        modelAndView.addObject("name", "Sergey");
        return modelAndView;

    }
}
