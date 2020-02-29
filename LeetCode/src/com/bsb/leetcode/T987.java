package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-29 15:47
 */
public class T987 {

    class Location implements Comparable<Location> {
        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                // 题目要求如果两个节点坐标一致 那么节点值较小的在前
                return Integer.compare(this.val, that.val);
        }
    }

    // 二叉树垂序遍历
    // 这题按照垂直的方向遍历二叉树 每一层如果有两个节点在"同一位置" 按照从左到右的顺序记录
    private List<Location> locations = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // 之前想过按照层次遍历的形式去处理每一层的节点然后直接添加
        // 但是处理左边界和右边界维护的时候必须得有一个坐标维护
        // 无奈之举 + 题解
        dfs(root, 0, 0);

        Collections.sort(locations);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int pre = locations.get(0).x;

        for (Location temp : locations) {

            // x坐标一致则表示是与前一个节点垂直的节点
            // 如果不是的话那么需要向res中新增一个集合
            if (temp.x != pre) {
                pre = temp.x;
                res.add(new ArrayList<>());
            }

            res.get(res.size() - 1).add(temp.val);
        }

        return res;
    }

    // dfs的时候构造Location实例
    public void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            // 只需要在dfs向下层递归的时候修改x或y的坐标即可
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x - 1, y + 1);
            dfs(node.right, x + 1, y + 1);
        }
    }
}


