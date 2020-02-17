package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 20:30
 */
public class T297 {
    // 序列化及反序列化二叉树

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helper(root, "");
    }

    public String helper(TreeNode root, String str) {

        if (root == null) {
            str += "null,";
        } else {
            str += (root.val) + ",";
            str = helper(root.left, str);
            str = helper(root.right, str);
        }
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strsArray = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strsArray));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list) {

        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);

        return root;
    }


    public static void main(String[] args) {
        new T297().deserialize("1,2,3,null,null,4,5");
    }
}
