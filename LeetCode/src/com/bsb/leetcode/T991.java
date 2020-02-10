package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 19:21
 */
public class T991 {

    // 坏了的计算器
    // 只能对X进行双倍或者减1操作
    // 求X->Y的最小操作次数
    // 思路是这样的 逆向思维Y怎么变到X 可以/2 也可以+1
    // 对于Y是偶数的情况 最优的操作是n次/2后 +1得到X
    // 对于Y是奇数的情况 最优的操作是+1 /2 +1得到X 最优操作都是n步 需要计算
    public int brokenCalc(int X, int Y) {
        int res = 0;
        // 当X>Y的时候就只能进行递减操作
        while (Y > X) {
            res++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }

        return res + X - Y;
    }
}
