package com.bsb.leetcode;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 15:45
 */
public class T155 {

    // 最小栈

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    public T155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
