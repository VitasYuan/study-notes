package com.example.business.dictionary;

import java.io.Serializable;

/**
 * @author yuanweipeng
 * @date 2018-01-19
 **/
public class Dictionary implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * id 自增
     */
    private int id;

    /**
     * 字典表key
     */
    private String dictKey = "";

    /**
     * 字典表value
     */
    private String dictValue = "";

    /**
     * 父节点id
     */
    private int parentId;

    /**
     * 描述信息
     */
    private String description = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dictionary() {
    }

    public Dictionary(String dictKey, String dictValue, int parentId, String description) {
        this.dictKey = dictKey;
        this.dictValue = dictValue;
        this.parentId = parentId;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", dictKey='" + dictKey + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                '}';
    }
}
