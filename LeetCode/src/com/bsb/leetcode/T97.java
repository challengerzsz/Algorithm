package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 15:38
 */
public class T97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1, 0, s2, 0, "", s3);
    }

    // 选取s1和s2的部分进行组合 和s3进行比较
    // 这个回溯的解其实是依赖s1的前i个字符和s2的前j个字符能不能组合成s3来实现的
    public boolean helper(String s1, int i, String s2, int j, String res, String s3) {
        // 标准回溯
        if (res.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        boolean ans = false;
        if (i < s1.length())
            // 这里对下层递归返回的结果需要进行 |=的处理 因为有的结果集不一定能满足 有的可能回溯之后会满足结果
            // 取s1的第i个字符
            // 向下递归
            // 这里后来的回溯其实是不需要对res做任何操作的 因为res是保存在每一层helper方法栈中的
            // 递归返回的时候相当于jvm自动处理了回溯删除上一步选择
            ans |= helper(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            ans |= helper(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;

    }

    // 根据上面的回溯思路
    // 定义动态规划状态和dp数组含义 以及状态转移的方式
    // 定义dp[i][j]为s1的前i个元素和s2的前j个元素能否构成s3
    // 那么dp[s1.length][s2.length]就是最后的解
    public boolean isInterleaveByDp(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // 初始化dp数组的第一行和第一列
        // 思考一下dp[i][j]的定义 其实就是i + j位从s1和s2中选择出来的不同的字符序列能否构成s3的前i + j位
        // 思考一下dp[i][0]就是s1的第i个元素能否构成s3的前i + 0位
        // 并且初始化第一行和第一列的时候一定要考虑dp[i - 1][0] 和 dp[0][j - 1]是否为true
        // 如果前i - 1的s1不能构成s3的前i - 1位 那第i位也就不考虑了 同理s2 也就是第一行和第一列的dp填充
        dp[0][0] = true;
        // 这里一定要注意后面的==判断条件.. 因为dp数组的大小所以需要进行 - 1操作...
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        // 初始化第一行
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // dp[i][j] 就需要考虑这一步是由s1的i构成还是s2的j字符构成
                // 如果选择s1的i的话 那么s1的i - 1必然是构成s3的i + j - 1的元素
                // 如果选择s2的j的话 那么s2的j - 1必然是构成s3的第i + j - 1个元素
                // 所以dp[i][j]的状态转移应该是如下的
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        new T97().isInterleaveByDp("aabcc", "dbbca", "aadbbcbcac");
    }

}
