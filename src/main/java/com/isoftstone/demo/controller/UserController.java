package com.isoftstone.demo.controller;

import com.isoftstone.demo.bean.Result;
import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.service.UserService;
import com.isoftstone.demo.util.Page;
import com.sun.org.apache.regexp.internal.REUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static Map<String,String> userMap=new HashMap<>();

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home(){
        return "login";
    }


    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        boolean result=userService.findUser(user);
        if(!result){
            return "error";
        }else{
            userMap.put("username",user.getName());
            return "goodsList";
        }
    }


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


    /**
     * 获取登录用户
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Result getName(){
        if(userMap.get("username")==null){
            return Result.error("未获取到登录信息");
        }
        return Result.success(userMap.get("username"));
    }

}
