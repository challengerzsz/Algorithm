package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 17:24
 */
public class T4 {

    // 从两个排序数组中计算中位数
    // 要求时间复杂度log(m + n)
    // 合并再计算的话就是O(n)了
    // log一出现立马会想到二分  二分没想出来怎么解
    // 这个思路是通过nums1和nums2的长度计算中位数的位置
    // 移动两数组的指针找到位置计算
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len = nums1.length + nums2.length;
        int resultIndex = len / 2;
        int resultIndexPre = resultIndex - 1;

        int res, resPre = 0;
        // 中位数是两个数的均分还是一个数 总长度是奇数还是偶数
        boolean flag = len % 2 == 0;

        while (i < nums1.length || j < nums2.length) {
            int nowI = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int nowJ = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (nowI < nowJ) {
                if (i + j == resultIndexPre) resPre = nums1[i];
                if (i + j == resultIndex) {
                    res = nums1[i];
                    if (flag) return (resPre + res) / 2.0;
                    else return res;
                }
                i++;
            } else {
                if (i + j == resultIndexPre) resPre = nums2[j];
                if (i + j == resultIndex) {
                    res = nums2[j];
                    if (flag) return (resPre + res) / 2.0;
                    else return res;
                }
                j++;
            }
        }
        return 0;
    }

    // 转换为第k小的数
    // 上面那种解法其实是一位一位排除掉不在最终中位数下标的数字进而计算的
    // 题解： 其实没必要每次都只一位一位排除
    // 如果说两个数组元素各有2个元素 一共就有4个元素 那么我们需要找到排序后的第2和第3个数字 在这里 k就是3 kPer就是2
    // 每次都可以剔除k/2个元素 也就是1个元素 如果数组的元素数量大了之后 一次排除的就不止一个了
    // 借助二分
    // https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/leetcode-4-median-of-two-sorted-arrays-xun-zhao-li/
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int kPre = (len + 1) / 2;
        int k = (len + 2) / 2;

        if (len % 2 == 0)
            return (helper(nums1, 0, n - 1, nums2, 0, m - 1, kPre)
                    + helper(nums1, 0, n - 1, nums2, 0, m - 1, k)) / 2.0;
            // 偶数的话就需要计算k和kPre的平均数
        else return helper(nums1, 0, n - 1, nums2, 0, m - 1, k);
    }

    private int helper(int[] nums1, int nums1Start, int nums1End, int[] nums2, int nums2Start, int nums2End, int k) {
        int len1 = nums1End - nums1Start + 1;
        int len2 = nums2End - nums2Start + 1;

        if (len1 > len2) return helper(nums2, nums2Start, nums2End, nums1, nums1Start, nums1End, k);

        // 其中某个数组已经去除掉了一部分元素 直接返回nums2[nums2Start + k - 1]
        if (len1 == 0) return nums2[nums2Start + k - 1];

        // 如果两个数组的长度和是0
        if (k == 1) return Math.min(nums1[nums1Start], nums2[nums2Start]);
        int i = nums1Start + Math.min(len1, k / 2) - 1;
        int j = nums2Start + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j])
            return helper(nums1, nums1Start, nums1End, nums2, j + 1, nums2End, k - (j - nums2Start + 1));
        else
            return helper(nums1, i + 1, nums1End, nums2, nums2Start, nums2End, k - (i - nums1Start + 1));
    }
}
