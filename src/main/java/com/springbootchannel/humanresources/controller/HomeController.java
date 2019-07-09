package com.springbootchannel.humanresources.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String grtHomePage(){

        return "Home";
    }
}
