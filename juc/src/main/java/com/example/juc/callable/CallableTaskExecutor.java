package com.example.juc.callable;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author weipeng_yuan
 * @date 2020-05-08 10:06
 */
@Component
public class CallableTaskExecutor {

    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Scheduled(fixedDelay = 1000)
    public void pushTask() {

        try {
            List<Future> futureList = new ArrayList<>();
            futureList.add(threadPool.submit(new CallableTask()));

            for (int i = 0; i < futureList.size(); i++) {
                try {
                    Future future = futureList.get(i);
                    List<Integer> result = (List<Integer>) future.get();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {

        }
    }
}
