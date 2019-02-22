package com.isoftstone.demo.service.impl;

import com.isoftstone.demo.bean.Goods;
import com.isoftstone.demo.kit.DateFormatKit;
import com.isoftstone.demo.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);

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

    @Override
    public String save(Goods goods, ModelMap model) {
        model.put("name",goods.getName());
        model.put("size",goods.getSize());
        model.put("image",goods.getImage());
        return model.get("image").toString();
    }
}
