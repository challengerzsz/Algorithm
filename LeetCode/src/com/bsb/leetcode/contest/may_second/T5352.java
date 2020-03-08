package com.bsb.leetcode.contest.may_second;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-08 10:31
 */
public class T5352 {

    public String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= n - 1; i++) {
            res.append((char) (i + 'a'));
            if ((n - i - 1) % 2 != 0) {
                for (int j = i + 1; j <= n - 1; j++) res.append((char) (i + 1 + 'a'));
                break;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T5352().generateTheString(7));
    }
}
