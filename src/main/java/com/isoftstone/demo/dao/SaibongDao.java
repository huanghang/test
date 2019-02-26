package com.isoftstone.demo.dao;


import com.isoftstone.demo.bean.SaibongHistory;
import com.isoftstone.demo.bean.SaibongRules;
import com.isoftstone.demo.util.SaibongUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 * 采番接口
 */
public interface SaibongDao {

    /**
     * 获取采番规则
     *
     * @param saibongUtil
     * @return
     */
    SaibongRules getSaibongRules(SaibongUtil saibongUtil);


    /**
     * 新增一条记录
     *
     * @param saibongUtil
     */
    void saveSaibong(SaibongUtil saibongUtil);


    /**
     * 更新记录
     *
     * @param saibongHistory
     */
    void upateSaibong(SaibongHistory saibongHistory);
    /**
     * 获取采番记录
     *
     * @param saibongUtil
     * @return
     */
    SaibongHistory getSaibong(SaibongUtil saibongUtil);



}
