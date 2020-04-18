package com.bsb.bytedance.prepare;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-18 20:58
 */
public class T337 {

    // 树形dp 打家劫舍III
    Map<TreeNode, Integer> hashMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;

        if (hashMap.containsKey(root)) return hashMap.get(root);

        int robIt = root.val + (root.left == null ? 0 : (rob(root.left.left) + rob(root.left.right)))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int notRobIt = rob(root.left) + rob(root.right);

        int res = Math.max(robIt, notRobIt);
        hashMap.put(root, res);

        return res;
    }
}
