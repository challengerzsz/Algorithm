package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 20:15
 */
public class GCD {

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int minMax(int a, int b) {
        int gcd = gcd(a, b);
        return a * b / gcd;
    }

    public static void main(String[] args) {
        System.out.println(new GCD().gcd(7890, 123456));
        System.out.println(new GCD().minMax(7890, 123456));
    }
}
