package com.zjut.netty.server.concept;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanweipeng
 * @date 2017-12-22
 **/
public class ConceptDemo extends Thread{

    private static final Object LOCK = new Object();

    private static int AWARD_NUM = 10;

    private CountDownLatch latch;

    public ConceptDemo(String threadName, CountDownLatch countDownLatch){

        setName(threadName);
        this.latch = countDownLatch;
    }

    @Override
    public void run() {
        getAward();
    }

    public boolean getAward(){
        boolean result ;

        synchronized (LOCK) {
            System.out.println("Thread:" + Thread.currentThread().getName() + ",get lock.");
            try {
                Thread.sleep(1000 * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }

            result = AWARD_NUM > 0 ? true : false;
            AWARD_NUM--;
            System.out.println("AWARD_NUM:" + AWARD_NUM);
        }
        latch.countDown();
        return result;
    }

    public static void main(String []args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i =0; i < 10; i++) {
            //异步操作
             new ConceptDemo("BloceDemoThread_" + i, countDownLatch).start();
        }
        countDownLatch.await();
    }
}
