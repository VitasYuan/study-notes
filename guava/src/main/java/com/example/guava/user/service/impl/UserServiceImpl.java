package com.example.guava.user.service.impl;

import com.example.guava.user.User;
import com.example.guava.user.service.UserService;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author weipeng_yuan
 * @date 2018-08-05
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "defaultLocalCache")
    private Cache cache;

    @Override
    public User get(String userName) {
        Object object = cache.get("user_cache_key_" + userName).get();
        if (object == null) {
            //
        }
        return (User) object;
    }

    @Override
    public void insert(User user) {
        cache.put("user_cache_key_" + user.getName(), user);
    }
}
