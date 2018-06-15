package com.zjut.service;

import com.zjut.model.AverageValue;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yuanweipeng
 */
public interface HourAverageService{


    /**
     * @param startTime
     * @param endTime
     * @return
     */
    List<AverageValue> get(Date startTime, Date endTime);

    /**
     * @param record
     */
    void insert(AverageValue record);

}
