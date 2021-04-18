package com.zjq.wrappertype;

public class FreeTest {
    public static void main(String[] args) {
        Integer a = 5;
        System.out.println(a.toString(1,2));
        System.out.println(a.byteValue());
    }
    /**
     * byte占用 8位 一个字节，数字大小为-27—27-1
     * short占用 16位 两个字节，数字大小为-215—215-1
     * int占用 32位 四个字节，数字大小为-231—231-1
     * long占用 64位 八个字节，数字大小为-263—263-1
     * float占用 32位 四个字节，数字大小为1.4E-45~3.4E+38 , -1.4E-45~-3.4E+38。用二进制的指数形式表示一个浮点数的格式，如：101*22, 101*2-3
     * double占用 64位 八个字节，数字大小为4.9E-324~1.7E+308, -4.9E-324~-1.7E+308。
     * char占 16位 两个字节，数字大小为0—216-1，是unicode编码。字符的本来面目，我们为什么可以直接将一个数字赋给字符变量。
     * boolean占 8位 一个字节，其取值只有两个，true和false。
     */

}
