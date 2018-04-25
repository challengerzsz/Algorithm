package com.bsb.linkedList;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListSolution {

    //链表倒置
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }

        return arrayList;
    }

    //逆序链表
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            listNode.next = p;
            p = listNode;
            head = head.next;
        }
        return p;
    }


    //链表第K结点
    public ListNode FindKthToTail(ListNode head,int k) {
        int count = 0;
        if (head == null) return null;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }

        if (count < k) return null;

        ListNode p1 = head;
        for (int i = 0; i < count - k; i++) {
            p1 = p1.next;
        }
        return p;

    }

    //合并两个链表使之成为单调不减规则
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1 == null && list2 == null) return head;

        ListNode p = list1, q = list2;
        if (list1.val < list2.val) {
            head = list1;
            p = list1.next;
        } else {
            head = list2;
            q = list2.next;
        }

        ListNode temp = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                ListNode newNode = new ListNode(p.val);
                temp.next = newNode;
                temp = newNode;
                p = p.next;
            } else {
                ListNode newNode = new ListNode(q.val);
                temp.next = newNode;
                temp = newNode;
                q = q.next;
            }
        }

        if (p != null) temp.next = p;
        if (q != null) temp.next = q;

        return head;
    }


}
