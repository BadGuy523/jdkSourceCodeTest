package com.zjq.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class BlockQueueTest {
    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue(1);
        Thread threadIn = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int num = Double.valueOf(Math.random() * 10).intValue();
                queue.add(num);
                System.out.println(Thread.currentThread().getName() + ":入队列-" + num);
            }
        });
        Thread threadOut = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":出队列-" + queue.poll());

            }
        });
        threadIn.start();
        threadOut.start();
    }
}
