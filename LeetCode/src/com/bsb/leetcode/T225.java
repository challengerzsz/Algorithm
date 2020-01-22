package com.bsb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-22 10:40
 */
public class T225 {

    static Deque<Integer> stack = new LinkedList<>();

    /** Initialize your data structure here. */
    public T225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return stack.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
