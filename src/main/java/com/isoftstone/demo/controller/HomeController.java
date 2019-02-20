package com.isoftstone.demo.controller;

import com.isoftstone.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ResponseBody
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return homeService.print();
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String home1(){
        return "index";
    }
}
