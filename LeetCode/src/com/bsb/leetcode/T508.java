package com.bsb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 11:54
 */
public class T508 {

    // 出现次数最多的子树元素和
    // 以每个节点为root 求和所构成的树的和 然后计算出现的次数
    private Map<Integer, Integer> map = new HashMap<>();
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumHelper(root);
        // 流编程 将map中出现次数 == max的节点统计为数组
        return map.entrySet().stream().filter(entry -> 
                entry.getValue().equals(max)).mapToInt(Map.Entry::getKey).toArray();
    }

    private int sumHelper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = root.val + sumHelper(root.left) + sumHelper(root.right);
        int frequency = map.getOrDefault(sum, 0) + 1;
        max = frequency > max ? frequency : max;
        map.put(sum, frequency);
        return sum;
    }
}
