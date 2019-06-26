package com.example.business.dictionary.dao;

import com.example.business.dictionary.Dictionary;
import com.example.web.annotation.DemoServerMapper;

import java.util.List;

/**
 * 通过Mapper注解关联接口和mapper.xml
 *
 * @author yuanweipeng
 * @date 2018-01-19
 **/
@DemoServerMapper
public interface DictionaryDao {

    /**
     * 返回所有的dictionary列表
     *
     * @return 所有的dictionary列表
     */
    List<Dictionary> list();

    /**
     * 查询此key下的所有子节点
     *
     * @param key 数据字典key
     * @return 返回key所有的子节点列表
     */
    List<Dictionary> listChildrenByKey(String key);

    /**
     * 插入数据到数据库
     *
     * @param dictionary
     */
    int insert(Dictionary dictionary);

    /**
     * @return
     */
    Integer getId();

}
