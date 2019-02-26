package com.isoftstone.demo.util;

import java.io.Serializable;

/**
 * Created by huanghang on 2016/6/27.
 * 采番的参数
 */
public class SaibongUtil implements Serializable {
    private String cfzdm;
    private String zjz;
    private Integer number = 1;

    /**
     * 无参构造
     */
    public SaibongUtil() {
        super();
    }

    /**
     * 有参构造
     *
     * @param cfzdm 采番key
     * @param zjz   中间值
     */
    public SaibongUtil(String cfzdm, String zjz) {
        this.cfzdm = cfzdm;
        this.zjz = zjz;
    }

    /**
     * 有参构造
     *
     * @param cfzdm  采番key
     * @param zjz    中间值
     * @param number 生成个数
     */
    public SaibongUtil(String cfzdm, String zjz, Integer number) {
        this.cfzdm = cfzdm;
        this.zjz = zjz;
        this.number = number;

    }

    public String getCfzdm() {
        return cfzdm;
    }

    public void setCfzdm(String cfzdm) {
        this.cfzdm = cfzdm;
    }

    public String getZjz() {
        return zjz;
    }

    public void setZjz(String zjz) {
        this.zjz = zjz;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}
