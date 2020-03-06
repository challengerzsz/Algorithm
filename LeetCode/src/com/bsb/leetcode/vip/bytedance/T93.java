package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 19:02
 */
public class T93 {

    // 复原Ip地址
    // 回溯思想
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12) return res;

        helper(s, 0, 4, "", res);
        return res;
    }

    private void helper(String s, int index, int left, String temp, List<String> res) {
        if (left == 0 && index == s.length()) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }

        for (int i = index; i < index + 3; i++) {
            if (i < s.length()) {
                // index == i && s.charAt(i) == '0'证明是目前处理的是一部分的开头 不能以0开始
                if (i == index && s.charAt(i) == '0') {
                    helper(s, i + 1, left - 1, temp + s.charAt(i) + ".", res);
                    break;
                    // 这里不break的话下面if还会走 会多次添加0.0.0.0这种情况
                }
                if (Integer.parseInt(s.substring(index, i + 1)) <= 255) {
                    helper(s, i + 1, left - 1, temp + s.substring(index, i + 1) + ".", res);
                }
            }
        }
    }
}
