package com.bsb.tree;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * next指针指向root
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
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
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reCreateTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode reCreateTree(int[] pre, int startP, int endP, int[] in, int startI, int endI) {

        if (startP > endP || startI > endI) {
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
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
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
    public boolean VerifySquenceOfBST(int[] sequence) {

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

    public int ifQueue(int n, int[] a) {
        int count = 0;
        int[] b = new int[a.length];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = i;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                count++;
            }
        }
        return count;
    }

    // 二叉树中和为target的路径
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return res;

        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) res.add(new ArrayList<>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;
    }

    // 判断二叉树是否为平衡二叉树
    // 这题这种写法只考虑了是不是对每一个节点而言左右两个子树的高度差是不是<=1
    public boolean IsBalanced_Solution(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        if (Math.abs(right - left) > 1) return -1;
            // else 返回这棵树的最大深度
        else return 1 + (left > right ? left : right);
    }

    // 判断一个二叉树是不是镜像二叉树
    public boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || judge(pRoot.left, pRoot.right);
    }

    private boolean judge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return judge(node1.left, node2.right) && judge(node1.right, node2.left);
        }
    }

    // 二叉树的下一个节点 （给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    // 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。）
    ArrayList<TreeLinkNode> middleTraversalRes = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode p = pNode;
        while (p.next != null) {
            p = p.next;
        }
        TreeLinkNode root = p;
        middleTraversalHelper(root);
        for (int i = 0; i < middleTraversalRes.size(); i++) {
            if (pNode == middleTraversalRes.get(i)) {
                if (i == middleTraversalRes.size() - 1) return null;
                else return middleTraversalRes.get(i + 1);
            }
        }
        return null;
    }

    private void middleTraversalHelper(TreeLinkNode root) {
        if (root == null) return;
        middleTraversalHelper(root.left);
        middleTraversalRes.add(root);
        middleTraversalHelper(root.right);
    }

    // 按照之字型打印二叉树
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        // 这里是维护flag来表示层与层之间元素需要反转的
        boolean flag = false;
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> every = new ArrayList<>();
            // 这里因为一直用的是一个queue 要区分每一层的节点 只能用size在刚进循环的时候做记录
            // 否则下面offer之后size就是动态变换的了
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (!flag) {
                    every.add(node.val);
                } else {
                    // 可以用stack实现 push pop就好
                    every.add(0, node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (every.size() != 0) {
                res.add(every);
            }
            flag = !flag;
        }
        return res;
    }

    // 二叉树层次遍历
    // 利用queue
    ArrayList<ArrayList<Integer>> PrintForEveryDeep(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int everySize = 0;
        while (!queue.isEmpty()) {
            everySize = queue.size();
            ArrayList<Integer> everyList = new ArrayList<>();
            for (int i = 0; i < everySize; ++i) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                everyList.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            // 这里要注意everyList是默认每一层开始遍历之前就创建好了，可能会添加进去没有元素的list
            if (queue.size() != 0) res.add(everyList);
        }
        return res;
    }

    // 递归解
    ArrayList<ArrayList<Integer>> PrintForEveryDeepByRecursion(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        PrintForEveryDeepByRecursionDfsHelper(pRoot, res, 0);
        return res;
    }

    private void PrintForEveryDeepByRecursionDfsHelper(TreeNode root, ArrayList<ArrayList<Integer>> res, int deep) {
        if (root == null) return;
        if (deep < res.size()) {
            res.get(deep).add(root.val);
        } else {
            ArrayList<Integer> everyDeep = new ArrayList<>();
            everyDeep.add(root.val);
            res.add(everyDeep);
        }
        PrintForEveryDeepByRecursionDfsHelper(root.left, res, deep + 1);
        PrintForEveryDeepByRecursionDfsHelper(root.right, res, deep + 1);
    }

    // 序列化反序列化二叉树
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val + "!");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    // index变量，表示目前以反序列化到哪一个节点值
    // 这里index不要加上static变成全局变量 oc过用例的时候会出错
    int index = -1;
    // 同样用前序遍历的方式还原字符串
    TreeNode Deserialize(String str) {
        index++;
        String[] serializeStrArray = str.split("!");
        int length = serializeStrArray.length;
        if (index > length) {
            return null;
        }
        TreeNode node = null;
        if (!serializeStrArray[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(serializeStrArray[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    // 二叉搜索树的第k小的节点
    // 拿到题就有的思路 中序遍历拿到有序序列 找第k小
    TreeNode KthNode(TreeNode pRoot, int k) {
        ArrayList<TreeNode> midOrderList = new ArrayList<>();
        KthNodeHelper(pRoot, midOrderList);
        if (k <= 0 || k > midOrderList.size()) return null;
        return midOrderList.get(k - 1);
    }
    private void KthNodeHelper(TreeNode root, List list) {
        if (root == null) return;
        KthNodeHelper(root.left, list);
        list.add(root);
        KthNodeHelper(root.right, list);
    }
    // 递归解
    int count = 0;
    TreeNode resNode = null;
    TreeNode KthNodeByRecursion(TreeNode pRoot, int k) {
        if (pRoot == null) return null;

        if (count < k && pRoot.left != null) {
            KthNodeByRecursion(pRoot.left, k);
        }
        if (++count == k) {
            resNode = pRoot;
        }
        if (count < k && pRoot.right != null) {
            KthNodeByRecursion(pRoot.right, k);
        }
        return resNode;
    }


    public static void main(String[] args) {
//        int[] array = {7, 4, 5, 6};
//        System.out.println(new TreeSolution().VerifySquenceOfBST(array));

//        System.out.println(new TreeSolution().reverse(1230));

//        int[] a = {5, 2, 1, 3, 4};
//        System.out.println(new TreeSolution().ifQueue(5, a));
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(5);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(4);

//                   root(1)
//             /              \
//           node1(5)         node(5)
//           /   \              /     \
//      node2(2) node3(5) node5(1)   node6(4)
//        /
//     node4(3)
        root.left = node1;
        root.right = node;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        node.left = node5;
        node.right = node6;

//        new TreeSolution().FindPath(root, 10);
//        new TreeSolution().IsBalanced_Solution(root);
//        new TreeSolution().isSymmetrical(root);

        // 测试queue
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        new TreeSolution().PrintForEveryDeepByRecursion(root);
        new TreeSolution().KthNode(root, 1);
    }


}
