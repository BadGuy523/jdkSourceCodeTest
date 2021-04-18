package com.zjq.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptTest {
    /**
     * 中断测试
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread((new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            if (Thread.currentThread().isInterrupted()) {
//                System.out.println("正常中断");
//            } else {
//                System.out.println("未中断");
//            }
            }
        }));
        thread.start();
        thread.join();
        Thread.yield();
        thread.wait();
        thread.notify();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
