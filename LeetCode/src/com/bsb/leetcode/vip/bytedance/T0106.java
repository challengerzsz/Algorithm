package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-16 22:06
 */
public class T0106 {

    // 字符串压缩
    public String compressString(String S) {
        if (S == null || S.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        int left = 0, right = 1;
        int count = 1;
        while (right <= S.length() - 1) {
            if (S.charAt(right) == S.charAt(left)) {
                right++;
                count++;
            } else {
                res.append(S.charAt(left)).append(count);
                left = right++;
                count = 1;
            }
        }
        res.append(S.charAt(left)).append(count);
        return res.toString().length() < S.length() ? res.toString() : S;
    }
}
