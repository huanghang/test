package com.isoftstone.demo.service;

import com.isoftstone.demo.bean.Goods;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

public interface GoodsService {

    public String upload(String realPath,CommonsMultipartFile file) throws IOException;


    public String save(Goods goods, ModelMap model);
}
