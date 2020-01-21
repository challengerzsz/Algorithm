package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 22:04
 */
public class T234 {

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
}
