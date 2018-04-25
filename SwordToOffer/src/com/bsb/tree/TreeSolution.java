package com.bsb.tree;

import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class TreeSolution {
    private Scanner scanner = new Scanner(System.in);
    //    public void createTree(TreeNode treeNode) {
//        int node;
//        node = this.scanner.nextInt();
//
//        System.out.println(node);
//        if (node == -1) {
////            System.out.println("-1!!!!");
//            treeNode = null;
//        } else {
//            treeNode = new TreeNode(node);
//            createTree(treeNode.left);
//            createTree(treeNode.right);
//        }
//
//    }

    //重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = reCreateTree(pre, 0, pre.length -1, in, 0, in.length - 1);
        return root;
    }
    public TreeNode reCreateTree(int []pre, int startP, int endP, int []in, int startI, int endI) {

        if (startP > endP  || startI > endI) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startP]);

        for (int i = startI; i <= endI; i++) {
            if (pre[startP] == in[i]) {
                //中序向左递归
                root.left = reCreateTree(pre, startP + 1, startP + i, in, startI, i - 1);
                //中序向右递归
                root.right = reCreateTree(pre, i - startI + startP + 1, endP, in, i + 1, endI);
            }
        }
        return root;
    }

    //镜像二叉树
    public void Mirror(TreeNode root) {
        if (root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //判断是否为子树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        Stack<TreeNode> stack = new Stack<>();
        if (root2 == null) return false;
        return false;
    }

}
