package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-09 21:10
 */
public class T22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        helper("(", 1, 0, n, res);
//        res.forEach(System.out::println);
        return res;
    }

    private void helper(String str, int leftCount, int rightCount, int n, List<String> res) {
        if (leftCount > n || rightCount > n || rightCount > leftCount) return;
        if (leftCount == rightCount && (leftCount + rightCount) / 2 == n) res.add(str);

        helper(str + "(", leftCount + 1, rightCount, n, res);
        helper(str + ")", leftCount, rightCount + 1, n, res);
    }
}
