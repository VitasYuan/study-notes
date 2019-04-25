package com.zjut.mybatis.model;

import java.util.Date;

/**
 * @author yuanweipeng
 */
public class AverageValue {

    /**
     * id,自增主键
     */
    private int id;

    /**
     *平均值
     */
    private int averageVaule;

    /**
     *记录创建时间
     */
    private Date createdTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAverageVaule() {
        return averageVaule;
    }

    public void setAverageVaule(int averageVaule) {
        this.averageVaule = averageVaule;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "AverageValue [" +
                " id=" + id +
                ",  averageVaule=" + averageVaule +
                ",  createdTime=" + createdTime +
                "]";
    }
}
