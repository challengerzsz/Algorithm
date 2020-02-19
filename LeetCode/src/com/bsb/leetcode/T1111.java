package com.bsb.leetcode;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 17:20
 */
public class T1111 {
    // 有效括号的最大嵌套深度
    // 遇(入栈
    // 遇)计算
    // 栈的大小即为当前的嵌套深度
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.isEmpty()) {
            return new int[0];
        }
        int[] result = new int[seq.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                stack.push(i);
            } else {
                int depth = stack.size();
                int left = stack.pop();
                if (depth % 2 == 0) {
                    result[left] = 1;
                    result[i] = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new T1111().maxDepthAfterSplit("(()())");
    }
}
