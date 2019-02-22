package com.isoftstone.demo.service;


import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.util.Page;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;


public interface UserService {

    public Page<User> getList(Page page);


}
