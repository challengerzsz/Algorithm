package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-31 14:40
 */
public class T307 {


    // 这题其实就是个这 但是这解法超时
    // 所以引入两个个算法  一个叫sqrt分解(其实就是分段求和而已) 一个叫线段树
//    private int[] result;
//
//    public T307(int[] nums) {
//        this.result = nums;
//    }
//
//    public void update(int i, int val) {
//        result[i] = val;
//    }
//
//    public int sumRange(int i, int j) {
//        int results = 0;
//        for (int k = i; k <= j; k++) {
//            results += result[k];
//        }
//        return results;
//    }

//    private int[] block;
//    private int len;
//    private int[] nums;
//
//    public T307(int[] nums) {
//        this.nums = nums;
//        double l = Math.sqrt(nums.length);
//        len = (int) Math.ceil(nums.length / l);
//        block = new int[len];
//        for (int i = 0; i < nums.length; i++)
//            block[i / len] += nums[i];
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        int startBlock = i / len;
//        int endBlock = j / len;
//        if (startBlock == endBlock) {
//            for (int k = i; k <= j; k++)
//                sum += nums[k];
//        } else {
//            for (int k = i; k <= (startBlock + 1) * len - 1; k++)
//                sum += nums[k];
//            for (int k = startBlock + 1; k <= endBlock - 1; k++)
//                sum += block[k];
//            for (int k = endBlock * len; k <= j; k++)
//                sum += nums[k];
//        }
//        return sum;
//    }
//
//    public void update(int i, int val) {
//        int no = i / len;
//        block[no] = block[no] - nums[i] + val;
//        nums[i] = val;
//    }

    // 线段树

    private int[] tree;
    private int n;

    public T307(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    // 这里构建的线段树的每一个父节点的值都是左右两个子节点的求和
    // 线段树的根节点就是整个数组的求和
    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < 2 * n; i++, j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    public void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}
