package com.bsb.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
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
    public ListNode FindKthToTail(ListNode head, int k) {
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
    public ListNode Merge(ListNode list1, ListNode list2) {
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

    // 复杂链表克隆
    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return pHead;
        }
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p1 != null) {
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }

        while (p2 != null) {
            if (p2.next != null) {
                // 直接给map中的value存的新node对象复制next节点(同样也为新创建的node)
                map.get(p2).next = map.get(p2.next);
            } else {
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }

    // 两链表相交的第一个节点
    // 两个指针分别都走两个链表的长度，因为相交节点距末尾的距离无论是从任何一个链表走都是一样的
    // 这样有效地拼接之后利用长度差进行遍历，就可以知道相交的第一个节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p = pHead1, q = pHead2;
        while (p != q) {
            p = p == null ? pHead2 : p.next;
            q = q == null ? pHead1 : q.next;
        }
        return p;
    }

    // 链表环的入口 该链表不一定有环
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode q = pHead.next;
        ListNode p = pHead.next.next;
        while (p != null) {
            if (p == q) {
                p = pHead;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
            p = p.next.next;
            q = q.next;
        }
        return null;
    }

    // 删除排序链表的重复节点 删除后链表中无重复节点
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        // 构造伪头节点 避免头节点重复
        ListNode fakeHead = new ListNode(-520);
        fakeHead.next = pHead;
        // p指向伪头节点 q指向真正的链表头节点
        ListNode p = fakeHead, q = fakeHead.next;
        while (q != null) {
            if (q.next != null && q.next.val == q.val) {
                while (q.next != null && q.next.val == q.val) q = q.next;
                // q此时是一组重复数据的最后一个节点 还需要再往后走一个
                q = q.next;
                p.next = q;
            } else {
                p = q;
                q = q.next;
            }
        }
        return fakeHead.next;
    }


}
