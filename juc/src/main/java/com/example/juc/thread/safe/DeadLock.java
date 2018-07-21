package com.example.juc.thread.safe;

/**
 * @author weipeng_yuan
 * @date 2018-07-15
 */
public class DeadLock {
    private static final Object[] LOCK_ARRAY;

    static {
        LOCK_ARRAY = new Object[2];
        LOCK_ARRAY[0] = new Object();
        LOCK_ARRAY[1] = new Object();
    }

    public static void main(String[] args) throws Exception {
        TaskOne taskOne = new TaskOne();
        taskOne.start();

        TaskTwo taskTwo = new TaskTwo();
        taskTwo.start();
        System.out.println("finished");

    }

    private static class TaskOne extends Thread {

        @Override
        public void run(){
            synchronized (LOCK_ARRAY[0]) {
                try {
                    Thread.sleep(3000);

                } catch (Exception e) {
                }
                System.out.println("Get LOCK-0");
                synchronized (LOCK_ARRAY[1]) {
                    System.out.println("Get LOCK-1");
                }

            }
        }
    }

    private static class TaskTwo extends Thread {

        @Override
        public void run() {
            synchronized (LOCK_ARRAY[1]) {
                try {
                    Thread.sleep(1000 * 3);

                } catch (Exception e) {
                }
                System.out.println("Get LOCK-1");
                synchronized (LOCK_ARRAY[0]) {
                    System.out.println("Get LOCK-0");
                }
            }
        }
    }
}
