package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-11 22:56
 */
public class T22 {

    // 括号生成
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        helper("(", 1, 0, n, res);
        return res;
    }

    private void helper(String str, int leftCount, int rightCount, int n, List<String> res) {
        if (leftCount > n || rightCount > n || rightCount > leftCount) return;
        if (leftCount == rightCount && (leftCount + rightCount) / 2 == n) res.add(str);

        helper(str + "(", leftCount + 1, rightCount, n, res);
        helper(str + ")", leftCount, rightCount + 1, n, res);
    }

    public static void main(String[] args) {
        new T22().generateParenthesis(1);
    }
}
