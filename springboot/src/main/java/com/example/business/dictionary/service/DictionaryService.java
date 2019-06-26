package com.example.business.dictionary.service;

import com.example.business.dictionary.Dictionary;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-01-19
 **/
public interface DictionaryService {

    /**
     * 返回所有的字典数据
     *
     * @return 返回所有的dictioanry列表
     */
    List<Dictionary> list();

    /**
     * 根据key查询此key下面的所有子节点
     *
     * @param key 字典数据key
     * @return 此key下的所有子节点
     */
    List<Dictionary> listChildrenByKey(String key);

    /**
     * 插入数据到数据库
     *
     * @param dictionary
     */
    int insert(Dictionary dictionary);

}
