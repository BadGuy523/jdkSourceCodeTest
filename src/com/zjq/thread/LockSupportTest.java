package com.zjq.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    /**
     * park和unpart执行顺序&park响应中断测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "start");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "end");
            System.out.println("是否中断" + Thread.currentThread().isInterrupted());
        });
        thread.start();
//        LockSupport.unpark(thread);
        thread.interrupt();
        System.out.println("unpart before park");
    }

}
