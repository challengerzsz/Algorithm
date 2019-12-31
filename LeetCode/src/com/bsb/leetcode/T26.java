package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-31 09:40
 */
public class T26 {

    // 这里的返回值是删除重复项之后的数组长度
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 0 || nums.length == 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                // 这里注意++的使用方式 不然会出错
                // 目的其实就是如果有不一样的元素存在i j位置 直接把后者j位置的元素赋值给i后的位置
                nums[++i] = nums[j++];
            } else {
                j++;
            }
        }
        return i + 1;
    }


    // 双指针优化 因为原数组为排序数组 相同的元素出现位置必定两两相邻
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                // 这里是为了减少不必要的交换 因为如果数组本身无重复，原先写法就会出现次次赋值
                // 因为如果出现重复的话 两个元素节点必定相邻
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
