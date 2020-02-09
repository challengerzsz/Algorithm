package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 19:18
 */
public class T647 {

    // 计算回文字串数量
    public int countsubstrings(String s) {

        // 中心拓展算法 验证回文串 一共2n - 1个位置可以作为回文串的中心
        int n = s.length(), ans = 0;
        for (int center = 0; center <= 2 * n - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            // 中心拓展
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;

    }
}
