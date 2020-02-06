package com.bsb.test;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-06 14:01
 */
public class Test1 {

    // 1 2 4 8 16 32 64 128 256 512 1024
    private boolean judge(int num) {

        if (num == 1) return true;
        if (num % 2 != 0) return false;

        while (true) {
            num = num / 2;
            if (num == 1) return true;
            if (num % 2 != 0) return false;
        }
    }

    // 简单位运算
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        System.out.println(new Test1().judge(2049));
    }
}
