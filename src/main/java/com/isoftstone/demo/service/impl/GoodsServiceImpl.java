package com.isoftstone.demo.service.impl;

import com.isoftstone.demo.bean.Goods;
import com.isoftstone.demo.bean.User;
import com.isoftstone.demo.kit.DateFormatKit;
import com.isoftstone.demo.service.GoodsService;
import com.isoftstone.demo.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);

    /**
     * 分页显示
     * @param page
     * @return
     */
    @Override
    public Page<Goods> getList(Page page) {
        List<Goods> list = new ArrayList<>();
        Goods u1 = new Goods("1", "11","upload/images/20190222/Desert.jpg");
        Goods u2 = new Goods("2", "12","upload/images/20190222/Tulips.jpg");
        Goods u3 = new Goods("3", "13","");
        Goods u4 = new Goods("4", "14","");
        Goods u5 = new Goods("5", "15","");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        Integer total = 200;
        return new Page<Goods>(page.getPageSize(), page.getPageNum(), total, list);
    }

    /**
     * 上传文件
     * @param realPath
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public String upload(String realPath,CommonsMultipartFile file) throws IOException {
        System.out.println("fileName：" + file.getOriginalFilename());
        if (file == null) {
            log.warn("上传文件为空，上传失败！");
            return null;
        }
        String path = "upload"+"\\" + "images" + "\\" + DateFormatKit.getDateFormat("yyyyMMdd").format(new Date());
        if (!path.startsWith("/") && !path.startsWith("\\")) {
            path = "/" + path;
        }
        if (!path.endsWith("/") && !path.endsWith("\\")) {
            path = path + "/";
        }
        String fileName = file.getOriginalFilename();
        File filepath = new File(realPath+path, fileName);
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();//如果目录不存在，创建目录
        }
        file.transferTo(filepath);
        path=path+fileName;
        return path.replaceAll("\\\\","/").substring(1);
    }

    /**
     * 保存商品信息
     * @param goods
     * @param model
     * @return
     */
    @Override
    public String save(Goods goods, ModelMap model) {
        model.put("name",goods.getName());
        model.put("size",goods.getSize());
        model.put("image",goods.getImage());
        return model.get("image").toString();
    }
}
