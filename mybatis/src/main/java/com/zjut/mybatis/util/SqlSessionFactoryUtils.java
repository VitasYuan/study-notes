package com.zjut.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;

/**
 * @author yuanweipeng
 * @date 2019-04-25
 **/
public abstract class SqlSessionFactoryUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryUtils.class);

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory initSqlSessionFactory() {
        String configFile = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(configFile);

        } catch (Exception e) {
            LOGGER.error("initSqlSessionFactory failed.e", e);
        }

        synchronized (SqlSessionFactoryUtils.class) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }

        return sqlSessionFactory;

    }

    public static SqlSession openSession() {

        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
