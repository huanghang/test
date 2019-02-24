package com.isoftstone.demo.controller;

import com.isoftstone.demo.bean.Goods;
import com.isoftstone.demo.bean.Result;
import com.isoftstone.demo.service.GoodsService;
import com.isoftstone.demo.util.Page;
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
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String tolist() {
        return "goodsList";
    }

    /**
     * 跳到新增页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd() {
        return "goods";
    }

    /**
     * 分页
     *
     * @param name
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result page(String name, Page page) {
        String param = name;
        System.out.println(param);
        return Result.success(goodsService.getList(page));
    }

    /**
     * 上传图片
     *
     * @param request
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result fileUpload2(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) {
        try {
            String realPath = request.getServletContext().getRealPath("");
            return Result.success(goodsService.upload(realPath, file));
        } catch (IOException e) {
            return Result.error("上传失败！");
        }
    }

    /**
     * 保存商品信息
     *
     * @param goods
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(Goods goods) {
        if(goodsService.save(goods)){
            return Result.success("保存成功");
        }else{
            return Result.error("保存失败");
        }
    }

    /**
     * 删除
     *
     * @param goods
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(Goods goods) {
        if(goodsService.delete(goods)){
            return Result.success("删除成功");
        }else{
            return Result.error("删除失败");
        }
    }
}
