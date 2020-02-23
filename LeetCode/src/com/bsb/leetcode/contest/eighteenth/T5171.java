package com.bsb.leetcode.contest.eighteenth;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-23 10:41
 */
public class T5171 {

    public int[] closestDivisors(int num) {

        int a = (int) Math.ceil(Math.sqrt(num));
        int b = a;
        while (a * b != num + 1 && a * b != num + 2) {
            if (a * b > num + 2) b--;
            else a++;
        }
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(8));
        System.out.println(Math.ceil(Math.sqrt(8)));
    }
}
