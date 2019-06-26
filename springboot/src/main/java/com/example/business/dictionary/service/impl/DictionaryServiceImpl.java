package com.example.business.dictionary.service.impl;

import com.example.business.dictionary.Dictionary;
import com.example.business.dictionary.dao.DictionaryDao;
import com.example.business.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-01-19
 **/
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private static final String LIST_KEY = "jellyfish_dictionary_list";

    @Autowired
    private DictionaryDao dictionaryDao;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<Dictionary> list() {
        return dictionaryDao.list();
//        redisTemplate.opsForValue().set(LIST_KEY, null);
//        List<Dictionary> result = (List<Dictionary>) redisTemplate.opsForValue().get(LIST_KEY);
//
//        if (result == null) {
//            //由于mybatis使用缓存，高并发下能保证只查询一次数据库，缺点：缓存大小和缓存时间不可控
//            result = dictionaryDao.list();
//            redisTemplate.opsForValue().set(LIST_KEY, result);
//        }
//        int a = 1/0;
//        return result;
    }

    @Override
    public List<Dictionary> listChildrenByKey(String key) {

//        String cacheKey = getCacheKey(key);
////        List<Dictionary> result = (List<Dictionary>) redisTemplate.opsForValue().get(cacheKey);
//
//        if (result == null) {
//            result = dictionaryDao.listChildrenByKey(key);
////            redisTemplate.opsForValue().set(cacheKey, result);
//        }
//        return result;
        return null;
    }

    @Override
    public int insert(Dictionary dictionary) {
        return dictionaryDao.insert(dictionary);
//        redisTemplate.delete(LIST_KEY);
        //todo 删除listChildrenByKey的缓存
    }

    private String getCacheKey(String key) {
        return "jellyfish_dictionary_list_" + key;
    }
}
