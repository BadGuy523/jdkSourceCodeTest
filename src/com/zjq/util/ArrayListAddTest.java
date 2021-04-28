package com.zjq.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAddTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = 0; i < 5; i++) {
            if (list.get(i).equals(5)) {
                list.add(list.get(i));
            } else {
                System.out.println(list.get(i));
            }
        }
        // foreach方法会报java.util.ConcurrentModificationException异常
        for (Integer num: list) {
            if (num.equals(4)) {
                list.add(num);
            } else {
                System.out.println(num);
            }
        }
        // stream.foreach方法会报java.util.ConcurrentModificationException异常
        list.stream().forEach(data -> {
            if (data.equals(4)) {
                list.add(data);
            } else {
                System.out.println(data);
            }
        });
        // parallelStream.foreach方法会报java.util.ConcurrentModificationException异常
        list.parallelStream().forEach(data -> {
            if (data.equals(1)) {
                list.add(data);
            } else {
                System.out.println(data);
            }
        });
    }
}
