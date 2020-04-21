package com.bsb.leetcode.interview;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-21 17:17
 */
public class T51 {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) res++;
            }
        }

        return res;
    }

    // 归并 统计逆序对
    public int reversePairs2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] temp = new int[len];
        return helper(nums, 0, len - 1, temp);
    }

    /**
     * 计算在数组 nums 的索引区间 [left, right] 内统计逆序对
     *
     * @param nums  待统计的数组
     * @param left  待统计数组的左边界，可以取到
     * @param right 待统计数组的右边界，可以取到
     * @return
     */
    private int helper(int[] nums, int left, int right, int[] temp) {
        // 分到每个区间一个元素
        if (left == right) {
            return 0;
        }

        int mid = (left + right) >>> 1;

        int leftPairs = helper(nums, left, mid, temp);
        int rightPairs = helper(nums, mid + 1, right, temp);

        int res = leftPairs + rightPairs;
        // 这里意思是如果递归分下去的两个区间在即将合并之前
        // 已经保证了前一个区间的最后一个元素<后一个区间的第一个元素 也就是说两个区间已经保证了有序
        // 不会出现逆序对 所以这里也就不需要再合并了
        if (nums[mid] <= nums[mid + 1]) {
            return res;
        }

        // 计算合并过程中产生的逆序对
        int reversePairsBetween2Array = merge(nums, left, mid, right, temp);
        // 求和左区间的逆序数和右区间逆序对数以及跨两个区间的逆序对数
        return res + reversePairsBetween2Array;

    }

    /**
     * [left, mid] 有序，[mid + 1, right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        // 复制到辅助数组里，帮助我们完成统计
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // i 用完了，只能用 j
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                // j 用完了，只能用 i
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 此时前数组元素出列，不统计逆序对
                nums[k] = temp[i];
                i++;
            } else {
                // 此时后数组元素出列
                // 即出现逆序
                nums[k] = temp[j];
                j++;
                res += (mid - i + 1);
            }
        }
        return res;
    }

}
