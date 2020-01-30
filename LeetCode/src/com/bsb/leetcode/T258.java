package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 16:17
 */
public class T258 {

    public int addDigits(int num) {
        while (num > 9) {
            num = helper(num);
        }
        return num;
    }

    public int helper(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }

    // 递归
    int addDigits2(int num) {
        if (num == 0) return 0;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum < 10) return sum;
        else return (addDigits(sum));
    }

}
