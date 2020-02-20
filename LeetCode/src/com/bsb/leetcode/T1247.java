package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 20:50
 */
public class T1247 {

    // 交换两串中的任意字符 使得两个串最终的字符串相同
    // 求最小交换次数
    public int minimumSwap(String s1, String s2) {
        // 两两判断形如 xx 为一种 就为 1  xy 为另一种  就为 2
        if (s1 == null || s2 == null) return (s1 == null && s2 == null) ? 0 : -1;
        int x = 0, y = 0;
        int res = 0, xCount = 0, yCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    xCount++;
                    x++;
                } else {
                    yCount++;
                    y++;
                }
            }
            if (xCount >= 2) {
                res += 1;
                xCount -= 2;
            }
            if (yCount >= 2) {
                res += 1;
                yCount -= 2;
            }
        }
        //无论是 xx xy yy yx 都为偶数
        if ((x + y) % 2 == 1) {
            return -1;
        }
        return res + xCount + yCount;
    }
}
