package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 20:29
 */
public class T357 {

    // 计算0 ～ 10^n 之间各个数位都不一致的数字个数
    // n=1: res=10
    // n=2: 两位数第一位只能为1-9，第二位只能为初第一位之外的数，加上一位数的所有结果 res = 9 * 9 + 10 = 91
    // n=3: 三位数第一位只能为1-9，第二位只能为非第一位的数，第三位只能为非前两位的数，加上两位数的所有结果 res = 9 * 9 * 8 + 91 = 739
    public int countNumbersWithUniqueDigits(int n) {
        int res = 10, mul = 9;
        for (int i = 1; i < Math.min(n, 10); i++) {
            mul *= 10 - i;
            res += mul;
        }
        return res;
    }
}
