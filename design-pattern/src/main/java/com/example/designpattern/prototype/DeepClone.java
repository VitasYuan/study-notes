package com.example.designpattern.prototype;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weipeng_yuan
 * @date 2018-09-01
 */
public class DeepClone implements Cloneable{

    private Map<String, Object> map = new HashMap<>();

    public void addPair(String key, String value){
        map.put(key, value);
    }

    public Map<String , Object> getMap(){
        return map;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepClone  deepClone = null;
        try {
            deepClone = (DeepClone) super.clone();
            Map<String, Object> cloneMap = new HashMap<>();
            cloneMap.putAll(this.map);

            deepClone.map = cloneMap;
        } catch (Exception e) {

        }
        return deepClone;
    }
}
