package com.isoftstone.demo.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/24.
 * 采番记录(sibt01)
 */

public class SaibongHistory implements Serializable {
    private String cfzdm;           //采番key
    private Integer dqlsh;          //当前流水号
    private String zjz;             //中间值
    private String cjsj;              //创建时间
    private String gxsj;              //更新时间
    private Integer bgbs;               //变更标识
    private Integer bccs;               //补仓次数
    private Integer dcbcsx;             //单次补仓上限


    /**
     * 无参数构造方法
     */
    public SaibongHistory() {
        super();
    }

    /**
     * 带参数构造方法
     */
    public SaibongHistory(Integer bgbs) {
        this.bgbs = bgbs;
    }

    /**
     * 构造方法
     *
     * @param cfzdm 采番key
     * @param dqlsh 当前流水号
     * @param zjz   中间值
     */
    public SaibongHistory(String cfzdm, Integer dqlsh, String zjz) {
        this.cfzdm = cfzdm;
        this.dqlsh = dqlsh;
        this.zjz = zjz;
    }

    /**
     * 包含全部字段构造方法
     *
     * @param cfzdm  采番key
     * @param dqlsh  当前流水号
     * @param zjz    中间值
     * @param cjsj   创建时间
     * @param gxsj   更新时间
     * @param bccs   变更标识
     * @param bgbs   补仓次数
     * @param dcbcsx 单次补仓上限
     */
    public SaibongHistory(String cfzdm, Integer dqlsh, String zjz, String cjsj, String gxsj, Integer bccs, Integer bgbs, Integer dcbcsx) {
        this.cfzdm = cfzdm;
        this.dqlsh = dqlsh;
        this.zjz = zjz;
        this.cjsj = cjsj;
        this.gxsj = gxsj;
        this.bccs = bccs;
        this.bgbs = bgbs;
        this.dcbcsx = dcbcsx;
    }

    public String getCfzdm() {
        return cfzdm;
    }

    public void setCfzdm(String cfzdm) {
        this.cfzdm = cfzdm;
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

    public Integer getBgbs() {
        return bgbs;
    }

    public void setBgbs(Integer bgbs) {
        this.bgbs = bgbs;
    }

    public Integer getBccs() {
        return bccs;
    }

    public void setBccs(Integer bccs) {
        this.bccs = bccs;
    }

    public Integer getDcbcsx() {
        return dcbcsx;
    }

    public void setDcbcsx(Integer dcbcsx) {
        this.dcbcsx = dcbcsx;
    }
}
