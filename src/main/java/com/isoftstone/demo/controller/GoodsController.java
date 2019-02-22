package com.isoftstone.demo.controller;

import com.isoftstone.demo.bean.Goods;
import com.isoftstone.demo.bean.Result;
import com.isoftstone.demo.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 上传图片
     * @param request
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result fileUpload2(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) {
        try {
            String realPath = request.getServletContext().getRealPath("");
            return Result.success(goodsService.upload(realPath,file));
        } catch (IOException e) {
            return Result.error("上传失败！");
        }
    }

    /**
     * 保存商品信息
     * @param goods
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(Goods goods,ModelMap model) {
        return Result.success(goodsService.save(goods,model));
    }
}
