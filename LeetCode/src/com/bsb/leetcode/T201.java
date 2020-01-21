package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 18:29
 */
public class T201 {


    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int res = m;
        for (int i = m; i <= n; i++) {
            if (res == 0 || i == Integer.MAX_VALUE) {
                break;
            }
            res &= i;
        }
        return res;
    }


    public int rangeBitwiseAnd2(int m, int n) {
        int zeroFlag = 0;
        while (n > m) {
            zeroFlag++;
            m >>>= 1;
            n >>>= 1;
        }
        return m << zeroFlag;
    }
}
