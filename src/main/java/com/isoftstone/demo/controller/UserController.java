package com.isoftstone.demo.controller;

import com.isoftstone.demo.bean.Result;
import com.isoftstone.demo.service.UserService;
import com.isoftstone.demo.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 分页功能测试
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(Page page) {
        return Result.success(userService.getList(page));
    }

    public static void main(String[] args) {
        System.out.println(1);
    }


}
