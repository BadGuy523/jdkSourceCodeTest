package com.zjq.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRemoveTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // fori会报java.lang.IndexOutOfBoundsException异常：因为remove方法会使size-1，在最后get时就会数组下标越界
        // 删除最后一个元素不会报错，因为size-1后，不会再获取下一个元素。
        for (int i = 0; i < 5; i++) {
            if (list.get(i).equals(5)) {
                list.remove(list.get(i));
            } else {
                System.out.println(list.get(i));
            }
        }
        // foreach方法会报java.util.ConcurrentModificationException异常
        // 删除倒数第二个元素时不会报错，但是最后一个元素不会打印，TODO：why？
        for (Integer num: list) {
            if (num.equals(4)) {
                list.remove(num);
            } else {
                System.out.println(num);
            }
        }
        // stream.foreach方法会报java.util.ConcurrentModificationException异常
        // 删除倒数第二个元素时也会报错 TODO：why？
        list.stream().forEach(data -> {
            if (data.equals(4)) {
                list.remove(data);
            } else {
                System.out.println(data);
            }
        });
        // parallelStream.foreach方法会报java.util.ConcurrentModificationException异常
        // 删除倒数第二个元素时也会报错 TODO：why？
        list.parallelStream().forEach(data -> {
            if (data.equals(1)) {
                list.remove(data);
            } else {
                System.out.println(data);
            }
        });
    }
}
