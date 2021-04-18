package com.zjq.thread;


public class ThreadLocalTest {

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0; //初始化一个值
        }
    };

    public static void main(String[] args) {
        Thread[] thread = new Thread[5];
        for (int i = 0; i < 5; i++) {
            thread[i] = new Thread(() -> {
                int num = local.get(); //获得的值都是0
                local.set(num += 5); //设置到local中
                local.remove();
                int num2 = local.get(); //获得的值都是0
                System.out.println(Thread.currentThread().getName() + "-" + num);
                System.out.println(Thread.currentThread().getName() + "-" + num2);
            });
        }
        for (int i = 0; i < 5; i++) {
            thread[i].start();
        }
    }
}
