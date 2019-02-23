package com.isoftstone.demo.service.impl;

import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.service.UserService;
import com.isoftstone.demo.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Page<User> getList(Page page) {
        List<User> list = new ArrayList<>();
        User u1 = new User("张三", "11");
        User u2 = new User("张三", "12");
        User u3 = new User("张三", "13");
        User u4 = new User("张三", "14");
        User u5 = new User("张三", "15");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        Integer total = 200;
        return new Page<User>(page.getPageSize(), page.getPageNum(), total, list);
    }

    /**
     * 登录校验
     * @param user
     * @return
     */
    @Override
    public boolean findUser(User user) {
        if(user.getName().equals("admin")&&user.getPassword().equals("123456")){
            return true;
        }
        return false;
    }


}
