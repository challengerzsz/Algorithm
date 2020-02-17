package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 20:55
 */
public class T449 {

    // 序列化反序列化一个BST
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helper(root);
    }

    private String helper(TreeNode root) {
        if (root == null) return "#,";
        String str = root.val + ",";
        str += helper(root.left);
        str += helper(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] values = data.split(",");
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("#")) {
                array[i] = -1;
                continue;
            }
            array[i] = Integer.parseInt(values[i]);
        }
        return buildHelper(array, 0, array.length - 1);
    }

    private TreeNode buildHelper(int[] preOrder, int preStart, int preEnd) {
        TreeNode root = preOrder[preStart] == -1 ? null : new TreeNode(preOrder[preStart]);
        if (root == null || preStart == preEnd) {
            return root;
        }
        // 找以这个root为父节点的左子树的叶子结点位置
        int leftEnd = preStart;
        // 因为BST的左子树都是小于root.val的
        while (leftEnd < preEnd && (preOrder[leftEnd] == -1 || preOrder[leftEnd] <= root.val))
            leftEnd++;

        root.left = buildHelper(preOrder, preStart + 1, leftEnd - 1);
        // 剩下一部分肯定是root的右子树
        root.right = buildHelper(preOrder, leftEnd, preEnd);
        return root;
    }
}
