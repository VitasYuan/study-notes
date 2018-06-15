package com.zjut.dao;

import java.util.List;
import java.util.Map;

/**
 * @author yuanweipeng
 */
public interface BaseDao<T> {

    void insert(T record);

    List<T> get(Map<String, Object> params);

    void delete(Map<String, Object> params);

}
