package com.example.juc.thread.safe;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weipeng_yuan
 * @date 2018-07-18
 */
public class ThreadPoolTest {

    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 6,100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));

    public static void main(String[] args) throws Exception {
        for (int i = 0; i< 9; i++) {
            executorService.submit(new Task());
            System.out.println("Active thread:" + executorService.getActiveCount() + ".Task count:" + executorService.getTaskCount() + ".TaskQueue size:" + executorService.getQueue().size());
        }
    }

    private static class Task extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 100);
            } catch (Exception e) {

            }
        }
    }

}