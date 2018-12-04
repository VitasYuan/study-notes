package com.zjut.business.category;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private long id;

    /**
     * 类别名称
     */
    private String name = "";

    /**
     * 类型
     */
    private int type;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
