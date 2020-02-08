package com.bsb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-08 20:01
 */
public class T402 {

    // 删除k个数字使num最小
    // 可能删除k个数字之后num的前导为0 例如001 => 1
    // 这个题目的思路收到上一个贪心算法使用到stack的题目影响
    // num每一位数字都与左边数字比较 如果大于左边数字则push入栈
    // 否则弹栈至不大于当前数字(受stack.size和k的影响设置终止条件)
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return num;
        if (k > num.length()) return "0";
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast((int) num.charAt(0) - '0');
        for (int i = 1; i < num.length(); i++) {
            if (k > 0) {
                while (k > 0 && stack.size() > 0 && stack.getLast() > num.charAt(i) - '0') {
                    stack.pollLast();
                    k--;
                }
                if (num.charAt(i) == '0' && stack.isEmpty()) continue;
            }
            stack.addLast((int) num.charAt(i) - '0');
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) sb.append(stack.pollFirst());
        if (sb.length() == 0) return "0";
        if (k > 0) return sb.substring(0, sb.length() - k);
        return sb.toString();
    }

    public static void main(String[] args) {
//        new T402().removeKdigits("1432219", 3);
//        System.out.println((int) '1' - '0');
        System.out.println("123".substring(0, 2));
    }
}
