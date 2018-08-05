package com.example.guava.user.service;

import com.example.guava.user.User;

/**
 * @author weipeng_yuan
 * @date 2018-08-05
 */
public interface UserService {

    /**
     * 根据用户名获取用户对象
     *
     * @param userName 用户名
     * @return user对象
     */
    User get(String userName);

    /**
     * 保存user对象
     *
     * @param user 对象
     */
    void insert(User user);
}
