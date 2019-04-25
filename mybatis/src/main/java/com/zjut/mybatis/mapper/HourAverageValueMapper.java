package com.zjut.mybatis.mapper;

import com.zjut.mybatis.model.AverageValue;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2019-04-25
 **/
public interface HourAverageValueMapper {

    /**
     * 指定时间范围内的平均值
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 平均值
     */
    AverageValue get(@Param(value = "startTime") Date startTime, @Param(value = "endTime") Date endTime);

    /**
     * 新增平均值
     *
     * @param averageValue 平均值
     */
    void insert(AverageValue averageValue);
}
