package com.example.juc.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author weipeng_yuan
 * @date 2020-05-08 10:15
 */
public class CallableTask implements Callable<List<Integer>> {

    /**
     * Callable 和Runnable类似，其实例都是用来在其他线程执行，
     * 但是Callable可以返回结果，并且可以抛出可以捕获的异常
     */
    @Override
    public List<Integer> call() throws Exception {
        return new ArrayList<>();
    }

}
