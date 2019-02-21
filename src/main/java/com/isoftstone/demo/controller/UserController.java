package com.isoftstone.demo.controller;

import com.isoftstone.demo.bean.Result;
import com.isoftstone.demo.service.UserService;
import com.isoftstone.demo.util.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    protected final Log logger = LogFactory.getLog(getClass());

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result list(Page page){
        return  Result.success(userService.getList(page));
    }


}
