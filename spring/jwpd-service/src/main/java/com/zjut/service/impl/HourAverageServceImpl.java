package com.zjut.service.impl;

import com.zjut.dao.statistic.HourAverageValueDao;
import com.zjut.model.AverageValue;
import com.zjut.service.HourAverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuanweipeng
 */
@Service
public class HourAverageServceImpl implements HourAverageService{

    @Autowired
    private HourAverageValueDao hourAverageValueDao;

    @Override
    public List<AverageValue> get(Date startTime, Date endTime) {
        Map<String, Object> params = new HashMap<>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        return hourAverageValueDao.get(params);
    }

    @Override
    public void insert(AverageValue record) {
        hourAverageValueDao.insert(record);
    }


}
