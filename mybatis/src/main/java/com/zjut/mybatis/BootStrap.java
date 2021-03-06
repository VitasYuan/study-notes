package com.zjut.mybatis;

import com.zjut.mybatis.mapper.HourAverageValueMapper;
import com.zjut.mybatis.model.AverageValue;
import com.zjut.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2019-04-25
 **/
public class BootStrap {

    public static void main(String [] args) throws Exception {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSession();
            HourAverageValueMapper mapper = sqlSession.getMapper(HourAverageValueMapper.class);
            Date start = new Date(1540195123000L);
            Date end = new Date(1576195153000L);
            mapper.insert(new AverageValue( 1,new Date()));

            AverageValue averageValue =  mapper.get(start, end);

            System.out.println(averageValue);

            sqlSession = SqlSessionFactoryUtils.openSession();
            mapper = sqlSession.getMapper(HourAverageValueMapper.class);
            start = new Date(1540195123000L);
            end = new Date(1576195153000L);
            averageValue =  mapper.get(start, end);
            System.out.println(averageValue);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
