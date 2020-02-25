package com.bsb.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 11:08
 */
public class T756 {

    // 金字塔转换矩阵
    // bottom表示金字塔底部的元素
    // allowed集合的每一项包括金字塔一部分的[left, right, root]
    // 从给定的allowed + bottom串判断是否能够倒推到金字塔顶部
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        return dfs(bottom, allowed, 0, new StringBuilder());
    }

    private boolean dfs(String bottom, List<String> allowed, int index, StringBuilder next) {
        if (bottom.length() == 1) {
            return true;
        }
        // 以每一层的元素串替换bottom 向上继续递归
        if (index >= bottom.length() - 1) {
            bottom = next.toString();
            next = new StringBuilder();
            return dfs(bottom, allowed, 0, next);
        }
        String str = bottom.substring(index, index + 2);
        boolean flag = false;
        for (int i = 0; i < allowed.size(); ++i) {
            if (allowed.get(i).startsWith(str)) {
                next.append(allowed.get(i).charAt(2));
                flag = dfs(bottom, allowed, index + 1, next);
                if (flag) {
                    return true;
                }
                next.deleteCharAt(next.length() - 1);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String[] allowed = {"BCG", "CDE", "GEA", "FFF"};
        new T756().pyramidTransition("BCD", Arrays.asList(allowed));
    }
}
