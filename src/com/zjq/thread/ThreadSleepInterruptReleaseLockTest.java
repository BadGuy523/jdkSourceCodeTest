package com.zjq.thread;

import java.util.concurrent.TimeUnit;

/**
 * 测试sleep被中断后是否释放锁
 */
public class ThreadSleepInterruptReleaseLockTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(() -> {
           synchronized (lock) {
               System.out.println("睡眠线程抢占到锁");
               try {
                   TimeUnit.SECONDS.sleep(5);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            System.out.println("睡眠线程释放锁");
        });
        Thread generalThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("普通线程抢占到锁");
            }
            System.out.println("普通线程释放锁");
        });
        sleepThread.start();
        // 睡眠1s保证睡眠线程抢占到锁
        TimeUnit.SECONDS.sleep(1);
        sleepThread.interrupt();
        generalThread.start();
    }
}
