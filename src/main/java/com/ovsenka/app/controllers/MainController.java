package com.ovsenka.app.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping
    public ModelAndView getMainPage(){
        return new ModelAndView("mainpage");
    }

    @GetMapping("/register")
    public ModelAndView getRegPage(){ return new ModelAndView("register"); }

}
