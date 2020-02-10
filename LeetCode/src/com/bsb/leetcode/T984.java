package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 18:55
 */
public class T984 {

    // 返回字符串中包含A个a和B个b其中不能出现"aaa" "bbb"
    // 选择AB中最大的开始安排
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();

        while (A > 0 || B > 0) {
            // flag记录该安排a还是b
            boolean flag = false;
            int n = res.length();
            if (n >= 2 && res.charAt(n - 1) == res.charAt(n - 2)) {
                if (res.charAt(n - 1) == 'b')
                    flag = true;
            } else {
                if (A >= B)
                    flag = true;
            }

            if (flag) {
                A--;
                res.append('a');
            } else {
                B--;
                res.append('b');
            }
        }

        return res.toString();
    }
}
