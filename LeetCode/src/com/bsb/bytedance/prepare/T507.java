package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-21 16:26
 */
public class T507 {

    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;

        int sum = 0;
        int cur = num / 2;
        while (cur >= 1) {
            if (sum > num) return false;
            if (num % cur == 0) {
                sum += cur;
            }
            cur--;
        }

        return sum == num;
    }

    /**
     * 枚举 1～num^1/2
     * @param num
     * @return
     */
    public boolean checkPerfectNumber2(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum == num * 2;
    }
}
