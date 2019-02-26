package com.isoftstone.demo.bean;

import java.io.Serializable;

/**
 * add by master
 * Created by Administrator on 2016/6/24.
 * 采番规则(sibt02)
 */
public class SaibongRules implements Serializable {
    private String cfzdm;       //采番key
    private String twz;         //头文字
    private Integer lscd;       //流水长度
    private Integer isb0;       //补0规则
    private char sx1;           //番号组成顺序1
    private char sx2;           //番号组成顺序2
    private char sx3;           //番号组成顺序3
    private String fgf;         //分隔符
    private String cfsm;        //采番说明

    private Integer dqlsh;          //当前流水号
    private String zjz;             //中间值
    private String cjsj;              //创建时间
    private String gxsj;              //更新时间

    /**
     * 无参数构造方法
     */
    public SaibongRules() {
        super();
    }

    /**
     * 只含主键参数构造方法
     */
    public SaibongRules(String cfzdm) {
        this.cfzdm = cfzdm;
    }

    /**
     * 保护全部参数构造方法
     *
     * @param cfzdm 采番key
     * @param twz   头文字
     * @param lscd  流水长度
     * @param isb0  是否补零
     * @param sx1   番号组成顺序1
     * @param sx2   番号组成顺序2
     * @param sx3   番号组成顺序3
     * @param fgf   分隔符
     */
    public SaibongRules(String cfzdm, String twz, Integer lscd, Integer isb0, char sx1, char sx2, char sx3, String fgf) {
        this.cfzdm = cfzdm;
        this.twz = twz;
        this.lscd = lscd;
        this.isb0 = isb0;
        this.sx1 = sx1;
        this.sx2 = sx2;
        this.sx3 = sx3;
        this.fgf = fgf;
    }

    public String getTwz() {
        return twz;
    }

    public void setTwz(String twz) {
        this.twz = twz;
    }

    public String getCfzdm() {
        return cfzdm;
    }

    public void setCfzdm(String cfzdm) {
        this.cfzdm = cfzdm;
    }

    public Integer getLscd() {
        return lscd;
    }

    public void setLscd(Integer lscd) {
        this.lscd = lscd;
    }

    public Integer getIsb0() {
        return isb0;
    }

    public void setIsb0(Integer isb0) {
        this.isb0 = isb0;
    }

    public char getSx1() {
        return sx1;
    }

    public void setSx1(char sx1) {
        this.sx1 = sx1;
    }

    public char getSx2() {
        return sx2;
    }

    public void setSx2(char sx2) {
        this.sx2 = sx2;
    }

    public String getFgf() {
        return fgf;
    }

    public void setFgf(String fgf) {
        this.fgf = fgf;
    }

    public char getSx3() {
        return sx3;
    }

    public void setSx3(char sx3) {
        this.sx3 = sx3;
    }


    public Integer getDqlsh() {
        return dqlsh;
    }

    public void setDqlsh(Integer dqlsh) {
        this.dqlsh = dqlsh;
    }

    public String getZjz() {
        return zjz;
    }

    public void setZjz(String zjz) {
        this.zjz = zjz;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getGxsj() {
        return gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }

    public String getCfsm() {
        return cfsm;
    }

    public void setCfsm(String cfsm) {
        this.cfsm = cfsm;
    }
}
