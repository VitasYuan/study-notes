package com.zjut.task;

import com.zjut.model.AverageValue;
import com.zjut.service.HourAverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @author yuanweipeng
 */
@Service
public class DataFactory {

    @Autowired
    private TaskExecutor executor;

    @Autowired
    private HourAverageService hourAverageService;

    public TaskExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }

    public void dataFactory(){

        for (int i =0; i < 10; i++){
            executor.execute(new DataSimulation());
        }
    }

    class DataSimulation implements Runnable{

        @Override
        public void run() {

            Random random = new Random();
            AverageValue averageValue = new AverageValue();
            averageValue.setAverageVaule(random.nextInt(100));
            averageValue.setCreatedTime(new Date());
            hourAverageService.insert(averageValue);

        }
    }

}
