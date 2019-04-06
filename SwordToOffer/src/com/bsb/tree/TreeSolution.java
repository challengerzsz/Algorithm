package com.bsb.tree;

import java.util.ArrayList;
import java.util.Arrays;
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

    //计算树的高度
    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int r = TreeDepth(root.right);
        int l = TreeDepth(root.left);
        if (r > l) return (r + 1);
        return (l + 1);
    }

    // 二叉树层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {



        ArrayList<Integer> treeNodeArrayList = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return treeNodeArrayList;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.remove(0);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
            treeNodeArrayList.add(node.val);
        }

        return treeNodeArrayList;
    }

    // 判断一个序列是不是二叉搜索树的后续遍历的结果
    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        int i = 0;
        for (; i < sequence.length - 1; ++i) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < sequence.length - 1; ++j) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            int[] newSequence = Arrays.copyOfRange(sequence, 0, i);
            left = VerifySquenceOfBST(newSequence);
        }

        boolean right = true;
        if (i < sequence.length - 1) {
            int[] newSequence = Arrays.copyOfRange(sequence, i, sequence.length - 1);
            right = VerifySquenceOfBST(newSequence);
        }

        return (right && left);

    }

    public static void main(String[] args) {
        int[] array = {7,4,5,6};
        System.out.println(new TreeSolution().VerifySquenceOfBST(array));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {
            return null;
        }

        ArrayList<TreeNode> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int num = 1;
        arrayList.add(root);
        int sum = root.val;
        while (true) {

        }
    }

    private ArrayList<Integer> transferToArrayInt(ArrayList<TreeNode> treeNodes) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (TreeNode node : treeNodes) {
            arrayList.add(node.val);
        }

        return arrayList;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode node = pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                arrayList.add(node);
                node = node.right;
            }

        }

        if (arrayList.size() == 1) {
            pRootOfTree.left = pRootOfTree;
            pRootOfTree.right = pRootOfTree;
        }

        for (int i = 0; i < arrayList.size(); i++) {


            if (i == 0) {
                arrayList.get(i).left = null;
                arrayList.get(i).right = arrayList.get(i + 1);
                continue;
            }
            if (i == arrayList.size() - 1) {
                arrayList.get(i).right = null;
                arrayList.get(i).left = arrayList.get(i - 1);
                continue;
            }

            arrayList.get(i).right = arrayList.get(i + 1);
            arrayList.get(i).left = arrayList.get(i - 1);
        }

        return arrayList.get(0);
    }


}
