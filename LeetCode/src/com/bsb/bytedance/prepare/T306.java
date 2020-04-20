package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-20 20:30
 */
public class T306 {

    // 累加数
    public boolean isAdditiveNumber(String num) {
        return helper(num, 0, 0, 0, 0);
    }

    /**
     *
     * @param num
     * @param index 从num的0号位置开始计算
     * @param preSum 前面两个数的总和初始为0
     * @param preNum 前面一个数的值初始为0
     * @param k 当前搜索的数字是第几个数（需要先找到前两个再对第三个及以后进行分析，所以需要这个k）
     * @return
     */
    private boolean helper(String num, int index, long preSum, long preNum, int k) {
        // k > 2 && dfs下标已经达到num串的末尾 证明s串符合累加数的条件 s串能够满足题意
        if (k > 2 && index >= num.length()) return true;
        // len是当前数字的长度
        for (int len = 1; len + index <= num.length(); len++) {
            // preSum是之前二者的和 num[index, index + len - 1]是当前需要和前两数之和想要去匹配的数

            long result = checkIsSum(preSum, num, index, index + len - 1, k);
            // result > 0时表示当前匹配成功进入递归，此时result变成preNum
            // result + preNum变成当前数的前两个数字之和（一开始的preNum就是result的前一个数）
            if (result >= 0) {
                if (helper(num, index + len, result + preNum, result, k + 1)) return true;
            }
        }
        return false;
    }

    private long checkIsSum(long sum, String num, int start, int end, int k) {
        // num.charAt(l)如果是0的话 证明第三个数搜索的时候没找对位置 这题不包括前导为0的数字
        // 直接返回-1
        if (num.charAt(start) == '0' && start < end) return -1;
        long s = 0;
        // 计算num[start, end]表示的数字是多少
        while (start <= end) {
            s = s * 10 + num.charAt(start) - '0';
            start++;
        }
        // 如果此时检查的是两个加数的情况 直接返回计算后的s
        if (k < 2) return s;
        // 如果目前检查的是可能的第三个数也就是前两个数的和的时候就需要比较 看是否满足前两数之和
        return sum == s ? s : -1;
    }
}
