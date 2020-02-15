package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 22:04
 */
public class T234 {

    // 回文链表
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int q = 0;
        int p = list.size() - 1;
        while (q < p) {
            if (!list.get(q).equals(list.get(p))) {
                return false;
            }
            q++;
            p--;
        }
        return true;
    }

    private ListNode p;

    // 和上面的时间复杂度一致O(n) 递归解法其实空间复杂度也是O(n)只是这个空间复杂度是和函数递归栈的空间挂钩的
    // 而上面的时间复杂度是和链表长度相关的 其实递归也是和链表长度相关 只是两个空间复杂度衡量的方式不一样
    public boolean isPalindrome2(ListNode head) {
        p = head;
        return helper(head);
    }

    private boolean helper(ListNode currentNode) {
        if (currentNode != null) {
            if (!helper(currentNode.next)) return false;
            if (currentNode.val != p.val) return false;
            p = p.next;
        }
        return true;
    }

}
