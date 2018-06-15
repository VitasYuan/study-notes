package com.example.business.user;

import com.example.business.dictionary.Dictionary;
import com.example.web.annotation.DemoServerMapper;
import com.example.web.annotation.DemoUserMapper;

import java.util.List;

/**
 * 通过Mapper注解关联接口和mapper.xml
 *
 * @author yuanweipeng
 * @date 2018-01-19
 **/
@DemoUserMapper
public interface UserDao {

    /**
     * 返回所有的dictionary列表
     *
     * @return 所有的dictionary列表
     */
    List<String> list();

}
