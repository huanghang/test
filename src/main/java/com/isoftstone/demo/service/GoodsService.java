package com.isoftstone.demo.service;

import com.isoftstone.demo.bean.Goods;
import com.isoftstone.demo.util.Page;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.Map;

public interface GoodsService {

    public Page<Goods> getList(String name,Page page);

    public String upload(String realPath,CommonsMultipartFile file) throws IOException;


    public boolean save(Goods goods);

    public boolean delete(Goods goods);
}
