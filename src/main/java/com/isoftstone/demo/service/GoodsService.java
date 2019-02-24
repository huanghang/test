package com.isoftstone.demo.service;

import com.isoftstone.demo.bean.Goods;
import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.util.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

public interface GoodsService {

    public Page<Goods> getList(Page page);

    public String upload(String realPath,CommonsMultipartFile file) throws IOException;


    public boolean save(Goods goods);

    public boolean delete(Goods goods);
}
