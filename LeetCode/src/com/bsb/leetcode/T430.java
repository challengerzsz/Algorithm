package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 12:04
 */
public class T430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    // 扁平化多级链表
    public Node flatten(Node head) {
        if (head == null) return null;

        Node fakeHead = new Node(0, null, head, null);

        dfs(fakeHead, head);

        // dfs之后fakeHead的next就是真正的头节点 需要给头节点的prev指针置null
        fakeHead.next.prev = null;
        return fakeHead.next;
    }


    // 其实思路就是像先序遍历二叉树那样去做
    // dfs需要两个参数 因为需要在dfs的时候填充pre和cur的关系 双向链表
    public Node dfs(Node pre, Node cur) {
        if (cur == null) return pre;

        cur.prev = pre;
        pre.next = cur;

        Node tempNext = cur.next;

        Node tail = dfs(cur, cur.child);
        cur.child = null;

        return dfs(tail, tempNext);
    }
}
