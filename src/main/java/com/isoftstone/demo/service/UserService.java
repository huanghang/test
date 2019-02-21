package com.isoftstone.demo.service;


import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.util.Page;

public interface UserService {

    public Page<User> getList(Page page);
}
