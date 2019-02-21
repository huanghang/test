package com.isoftstone.demo.service.impl;

import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.service.UserService;
import com.isoftstone.demo.util.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public Page<User> getList(Page page) {
        List<User> list=new ArrayList<>();
        User u1=new User("张三","11");
        User u2=new User("张三","12");
        User u3=new User("张三","13");
        User u4=new User("张三","14");
        User u5=new User("张三","15");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        Integer total=200;
        return new Page<>(page.getPageSize(),page.getPageNum(),total,list);
    }
}
