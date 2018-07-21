package com.example.juc.thread.safe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author weipeng_yuan
 * @date 2018-07-15
 */
public class ThreadUnsafeDemo {

    private static final ExecutorService EXECUTOR_SERVICE;

    private static final Object LOCK = new Object();

    static {
        EXECUTOR_SERVICE = new ThreadPoolExecutor(100, 100, 1000 * 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100), new ThreadFactory() {

            private AtomicLong atomicLong = new AtomicLong(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-Safe-Thread-" + atomicLong.getAndIncrement());
            }
        });
    }


    public static void main(String[] args) throws Exception {
        Map<String, Integer> params = new HashMap<>();

        List<Future> futureList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            futureList.add(EXECUTOR_SERVICE.submit(new CacheOpTask(params)));
        }

        for (Future future : futureList) {
            System.out.println("Future result:" + future.get());
        }

        System.out.println(params);
    }

    private static class CacheOpTask implements Callable<Integer> {

        private Map<String, Integer> params;

        CacheOpTask(Map<String, Integer> params) {
            this.params = params;
        }

        @Override
        public Integer call() {
            for (int i = 0; i < 100; i++) {
                synchronized (LOCK) {
                    int count = params.getOrDefault("count", 0);
                    params.put("count", ++count);
                }
            }
            return params.get("count");
        }

    }
}



