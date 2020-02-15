package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 15:23
 */
public class T237 {

    // 删除链表指定节点
    // 只给定被删除的node
    // 很简单 广义上的删除 后续节点值依次覆盖
    // 但其实不需要写循环覆盖的过程 因为node题目说了不是尾节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
