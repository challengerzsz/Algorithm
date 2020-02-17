package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 15:26
 */
public class T312 {

    // 戳气球
    // 戳爆第i个气球 将会获得nums[left] * nums[i] * nums[right]奖励
    // 戳爆i之后 right和left将会变成相邻的两个气球
    // 求最大能获得的奖励
    // 首先想到的是枚举所有可能
    // 回溯思想尝试
    // 回溯超时 时间复杂度O(n!)
    int res = 0;

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        backTraceHelper(nums, 0, nums.length, 0);
        return res;
    }

    public void backTraceHelper(int[] nums, int deep, int length, int preCount) {
        // 递归中止条件
        if (deep == length) {
            if (preCount > res) {
                res = preCount;
            }
            return;
        }
        for (int i = 0; i < length; i++) {
            // 已经戳破的气球不再考虑
            if (nums[i] == -1) {
                continue;
            }
            // 戳破上一层中未戳破的气球 保存至temp是为了回溯还原该值
            int temp = nums[i];
            nums[i] = -1;

            // 获取左侧相邻的未戳破气球
            int left = i - 1;
            int leftNum;
            while (left > -1 && nums[left] == -1) {
                left--;
            }
            // 判断是不是到了左侧边界 如果是的话 左侧边界的气球左侧邻居值为1
            if (left < 0) {
                leftNum = 1;
            } else {
                leftNum = nums[left];
            }
            // 获取右侧相邻气球的分数
            int next = i + 1;
            int nextNum;
            while (next < length && nums[next] == -1) {
                next++;
            }
            // 同理左侧处理方式
            if (next > length - 1) {
                nextNum = 1;
            } else {
                nextNum = nums[next];
            }
            // 计算戳破当前气球的分值
            int tempCoin = temp * nextNum * leftNum;
            // 递归下一层选择下一次选择的硬币
            backTraceHelper(nums, deep + 1, length, preCount + tempCoin);
            // 回溯
            // 撤销这一步戳破第i个气球
            nums[i] = temp;
        }
    }

    // 看到一个题解说 遇到O(n!)的时间复杂度一定要去思考能否用分治思想去优化？
    // 例如 当前区间为i～j 此时如果选择k下标去戳破 那么将会分治为两个区间去进行求解 即i ~ k - 1 k + 1 ~ j
    // 但是如果我们戳破的是k下标的气球 那么此时k - 1和k + 1就变成相邻的两个气球了 并且 k - 1和k + 1这两个位置的气球
    // 不管是谁先被戳爆 所得到的结果都是不一致的
    // 所以这种分治(从一开始该戳哪个气球到戳完全部气球的分治解)出现了两个子问题的各自求解发生相互依赖的问题
    // 那么分治的思路应该是 不戳破 i 与 j ，仅戳破 i 与 j 之间的气球我们能得到的最大金币数。
    // 如此划分，状态转移方程为： def( i, j ) = def( i , k ) + def( k , j ) + nums[ i ][ j ][ k ]
    // nums[ i ][ j ][ k ]表示戳爆k的时候的收益
    // 分治的思想应该是在i ～ j区间内枚举所有有可能的k 计算最大值
    // def( i, j ) = max { def( i , k ) + def( k , j ) + nums[ i ][ j ][ k ] } | i<k<j
    public int maxCoins2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // 增加虚拟边界 最左侧和最右侧的相邻气球都置为1
        int length = nums.length;
        int[] newNums = new int[length + 2];
        System.arraycopy(nums, 0, newNums, 1, length);
        newNums[0] = 1;
        newNums[length + 1] = 1;
        length = newNums.length;
        // 缓存数组
        int[][] cache = new int[length][length];
        // 分治
        return divideHelper(newNums, length, cache);
    }

    public int divideHelper(int[] nums, int length, int[][] cache) {
        return divideCountHelper(nums, length, 0, length - 1, cache);
    }

    public int divideCountHelper(int[] nums, int length, int begin, int end, int[][] cache) {
        // 递归出口
        // begin和end表示这一步分治的两个边界
        // 因为我们的分治思路不能戳破每一步的左右两个边界
        // 所以当begin == end - 1即左右边界相邻的时候 中间没有多余的气球 这里直接返回0
        if (begin == end - 1) {
            return 0;
        }
        // 缓存，避免重复计算子问题
        if (cache[begin][end] != 0) {
            return cache[begin][end];
        }

        int max = 0;
        // 状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j ) + nums[ i ][ j ][ k ] } | i<k<j
        for (int i = begin + 1; i < end; i++) {
            // 在begin和end之间选择所有可能的k进行分治
            int temp = divideCountHelper(nums, length, begin, i, cache) + divideCountHelper(nums, length, i, end, cache)
                    + nums[begin] * nums[i] * nums[end];
            if (temp > max) {
                max = temp;
            }
        }
        cache[begin][end] = max;
        return max;
    }

    // 动态规划
    public static int maxCoinsByDp(int[] nums) {
        if (nums == null) {
            return 0;
        }

        // 还是一样先增加nums最左和最右的边界情况
        int length = nums.length;
        int[] newNums = new int[length + 2];
        System.arraycopy(nums, 0, newNums, 1, length);
        newNums[0] = 1;
        newNums[length + 1] = 1;

        //创建dp表
        int[][] dp = new int[length][length];

        // dp[i][j]表示 i ～ j区间内最大的解
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                int max = 0;
                // k的取值需要在i～j之间 如果进不了这个for那么也就说明i和j相邻
                for (int k = i + 1; k < j; k++) {
                    int temp = dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length - 1];
    }
}
