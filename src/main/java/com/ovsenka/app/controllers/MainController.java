package com.ovsenka.app.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/register")
    public ModelAndView getRegPage(){ return new ModelAndView("register"); }

    @GetMapping("/userpage")
    public ModelAndView getUserPage(Principal info){
        return new ModelAndView("userpage").addObject("usrname", info.getName()); }

}
