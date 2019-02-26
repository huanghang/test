package com.isoftstone.demo.service;


import com.isoftstone.demo.util.Page;
import com.isoftstone.demo.util.SaibongUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/27.
 * 采番接口
 */
public interface SaibongService {
    /**
     * 根据条件生成采番号
     *
     * @param saibongUtil（页面传进来的查询参数）
     * @return
     */
    List<String> getSaibongs(SaibongUtil saibongUtil);
}
