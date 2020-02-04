package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 14:15
 */
public class T95 {

    // 将1～n的数生成不同的二叉搜索树
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return helper(1, n);
    }

    public LinkedList<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<>();
        // 空节点
        if (start > end) {
            res.add(null);
            return res;
        }
        
        // 对每一个数都可以选择成为根节点
        for (int i = start; i <= end; i++) {
            
            // 所有情况的左子树
            LinkedList<TreeNode> left = helper(start, i - 1);
            // 所有情况的右子树
            LinkedList<TreeNode> right = helper(i + 1, end);

            // 左右子树连接
            // 这里有不同的左右子树集合
            // 这里需要嵌套去组合以i为root时的左右子树集
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    

}
