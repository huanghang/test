package com.isoftstone.demo.service.impl;

import com.isoftstone.demo.bean.SaibongHistory;
import com.isoftstone.demo.bean.SaibongRules;
import com.isoftstone.demo.dao.SaibongDao;
import com.isoftstone.demo.service.SaibongService;
import com.isoftstone.demo.util.SaibongUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 * 采番生成
 */
@Service
public class SaibongServiceImpl implements SaibongService {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SaibongDao saibongDao;

    /**
     * 根据条件生成采番号
     *
     * @param saibongUtil（页面传进来的查询参数）
     * @return
     */
    @Override
    public List<String> getSaibongs(SaibongUtil saibongUtil) {
        Integer ls = 0;
        //首先根据key查询采番规则表
        SaibongRules saibongRules = null;
        try {
            saibongRules = saibongDao.getSaibongRules(saibongUtil);
        } catch (Exception e) {
            logger.error("查询采番注册规则表出现异常,异常信息：",e);
        }
        //没有注册采番规则
        if (saibongRules == null) {
            return new ArrayList<>();
        } else {
            List<String> cfh = null;
            try {
                //已经注册规则，根据key,zjz查询采番记录
                SaibongHistory saibongHistories = saibongDao.getSaibong(saibongUtil);
                //没有找到采番记录
                if (saibongHistories == null) {
                    //首次采番，插入一条采番记录
                    saibongDao.saveSaibong(saibongUtil);
                } else {
                    //二次采番，获取当前流水号
                    ls = saibongHistories.getDqlsh();
                }
                saibongHistories = saibongDao.getSaibong(saibongUtil);
                //拼接采番号
                cfh = getCfh(saibongHistories, saibongRules, saibongUtil, ls);
                //更新采番流水号
                saibongDao.upateSaibong(saibongHistories);
            } catch (Exception e) {
                logger.error("生成采番号出现异常,异常信息：" ,e);
            }
            return cfh;
        }
    }





    /**
     * 根据采番规则、采番条件、流水号拼接采番号
     *
     * @param saibongHistories（采番记录）
     * @param saibongRules（采番规则）
     * @param saibongUtil（采番规则）
     * @param ls（流水号）
     * @return
     */
    private List<String> getCfh(SaibongHistory saibongHistories, SaibongRules saibongRules, SaibongUtil saibongUtil, Integer ls) {
        List<String> cfh = new ArrayList<String>();
        Integer number = saibongUtil.getNumber();       //需要获取的采番个数
        Integer maxlsh = 0;                             //采番流水长度规则的最大流水号
        String lsh = "";                                //记录采番流水号
        Integer isb0 = saibongRules.getIsb0();          //采番补零规则
        Integer lscd = saibongRules.getLscd();          //采番规则定义的流水长度
        Integer lsl = 0;                                //流水号的长度
        char sx1 = saibongRules.getSx1();               //流水号排序1
        char sx2 = saibongRules.getSx2();               //流水号排序2
        String twz = saibongRules.getTwz();             //头文字
        String zjz = saibongUtil.getZjz();              //中间值
        String fgf = saibongRules.getFgf();             //分隔符
        for (int i = 1; i <= number; i++) {
            //计算该采番的最大流水号
            maxlsh = (int) Math.pow(10, lscd) - 1;
            //当前流水号先加1，再判断
            ls = ls + 1;
            if (ls > maxlsh) {
                ls = 1;
            }
            //记录流水号
            lsh = ls.toString();
            //重新记录流水长度
            lsl = lsh.length();
            if (isb0 == 2) {
                //左补0
                for (int zb = lsl; zb < lscd; zb++) {
                    lsh = "0" + lsh;
                }
            } else if (isb0 == 3) {
                //右补0
                for (int zb = lsl; zb < lscd; zb++) {
                    lsh = lsh + "0";
                }
            }
            String str = "";
            //根据组成顺序拼接生成采番号

            //头文字排第一位的情况
            if (Integer.valueOf(sx1 + "") == 1) {
                if (twz != null && !twz.equals("")) {
                    str += twz + fgf;
                }
                //中间值排第二位
                if (Integer.valueOf(sx2 + "") == 2) {
                    if (zjz != null && !zjz.equals("")) {
                        str += zjz + fgf + lsh;
                    } else {
                        str += lsh;
                    }
                } else if (Integer.valueOf(sx2 + "") == 3) {
                    if (zjz != null && !zjz.equals("")) {
                        str += lsh + fgf + zjz;
                    } else {
                        str += lsh;
                    }
                }
                //中间值排第一位的情况
            } else if (Integer.valueOf(sx1 + "") == 2) {
                if (zjz != null && !zjz.equals("")) {
                    str += zjz + fgf;
                }
                //头文字排第二位
                if (Integer.valueOf(sx2 + "") == 1) {
                    if (twz != null && !twz.equals("")) {
                        str += twz + fgf + lsh;
                    } else {
                        str += lsh;
                    }
                } else if (Integer.valueOf(sx2 + "") == 3) {
                    if (twz != null && !twz.equals("")) {
                        str += lsh + fgf + twz;
                    } else {
                        str += lsh;
                    }
                }
                //流水号排第一位
            } else if (Integer.valueOf(sx1 + "") == 3) {
                //头文字排第二位
                if (Integer.valueOf(sx2 + "") == 1) {
                    if (twz != null && !twz.equals("")) {
                        if (zjz != null && !zjz.equals("")) {
                            str += lsh + fgf + twz + fgf + zjz;
                        } else {
                            str += lsh + fgf + twz;
                        }
                    } else {
                        if (zjz != null && !zjz.equals("")) {
                            str += lsh + fgf + zjz;
                        } else {
                            str += lsh;
                        }
                    }
                } else if (Integer.valueOf(sx2 + "") == 2) {  //中间值排第二位
                    if (zjz != null && !zjz.equals("")) {
                        if (twz != null && !twz.equals("")) {
                            str += lsh + fgf + zjz + fgf + twz;
                        } else {
                            str += lsh + fgf + zjz;
                        }
                    } else {
                        if (twz != null && !twz.equals("")) {
                            str += lsh + fgf + twz;
                        } else {
                            str += lsh;
                        }
                    }
                }
            }

            cfh.add(str);
        }
        //更新采番表(更新)流水号
        saibongHistories.setDqlsh(ls);
        return cfh;
    }
}
