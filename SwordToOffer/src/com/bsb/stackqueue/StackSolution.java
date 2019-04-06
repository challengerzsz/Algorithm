package com.bsb.stackqueue;

import java.util.Stack;

public class StackSolution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //双栈实现队列
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    // 判断出栈序列是否正确
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        boolean result = false;

        Stack stack = new Stack();
        int now = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[0]) {
                now = i;
                break;
            }
            stack.push(pushA[i]);
        }

        for (int j = 1; j < popA.length; j++) {
            if ((int)stack.peek() == popA[j]) {
                stack.pop();
                continue;
            }
            if ((int)stack.peek() != popA[j]) {
                for (int i = now + 1; i < pushA.length; i++) {
                    if (pushA[i] == popA[j]){
                        now = i;
                    } else {
                        stack.push(pushA[i]);
                    }
                }
            }
        }

        if (stack.empty()) {
            result = true;
        }

        return result;
    }
}
