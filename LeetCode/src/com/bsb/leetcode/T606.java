package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 21:17
 */
public class T606 {

    StringBuilder sb = new StringBuilder();

    // 二叉树转换为字符串 lj题
    // 形如root.left = left root.right = right  =>  root(left)(right)
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        help(t);
        return sb.toString();
    }

    private void help(TreeNode t) {
        if (t == null)
            return;
        if (t.left == null && t.right == null)
            sb.append(t.val);
        else if (t.right == null) {
            sb.append(t.val).append("(");
            help(t.left);

            sb.append(")");
        } else {
            sb.append(t.val).append("(");
            help(t.left);
            sb.append(")(");
            help(t.right);
            sb.append(")");
        }
    }
}
