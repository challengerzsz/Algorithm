package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-30 15:03
 */
public class T22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHelper(res, "",0,0, n);
        return res;
    }

    private void generateParenthesisHelper(List<String> res, String str, int i, int j, int n) {
        if (str.length() == n * 2) {
            res.add(str);
            return;
        }
        if (i < n) generateParenthesisHelper(res, str + '(', i + 1, j, n);
        if (j < i) generateParenthesisHelper(res, str + ')', i, j + 1, n);
    }
}
