package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 18:20
 */
public class T113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        sum -= root.val;

        list.add(root.val);
        if (root.left == null && root.right == null && sum == 0)
            // 这里add一个new list的原因也和下面回溯是否需要remove掉本步的选择一样 因为方法传递的参数list相当于全局的list
            // 如果直接add的话会导致其他层次递归的时候对他进行修改
            // 说白了 这种题目因为是回溯解 所以每一次都需要对list进行回溯取消本次递归进行的选择
            // 所以一定会在基于本步的递归完成之后 remove掉本步的选择 以至于到最后整个递归退出的时候list就成了空了
            // 所以需要把确定下来的结果集通过new的方式构造新的list加入res
            res.add(new ArrayList<>(list));

        helper(root.left, sum, list);
        helper(root.right, sum, list);

        // 递归返回的时候如果不应该在结果集 不要忘记remove
        // 回溯
        // 回溯过程中是否需要考虑对某个递归函数传递的参数进行remove掉这一步的选择是这样的
        // 如果形如list这类集合 因为从递归开始就是独一无二的一个引用 所以 递归函数每一层都会对他进行选择或删除的修改 传递到上层后
        // 因为不同于一些基本参数 这个引用不会随着递归栈的退出而改变 所以回溯一定要思考好递归参数会对回溯的选择和删除造成什么影响
        list.remove(list.size() - 1);
    }
}
