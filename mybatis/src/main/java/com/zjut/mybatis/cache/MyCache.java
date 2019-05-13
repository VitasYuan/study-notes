package com.zjut.mybatis.cache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author yuanweipeng
 * @date 2019-05-10
 **/
public class MyCache implements Cache {

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {

    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
