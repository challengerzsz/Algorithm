package com.bsb.leetcode;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-31 11:50
 */
public class T32 {

    // 1、暴力枚举出所有可能有效的字串进行判断 超时解
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // 这里j的step是2的原因是因为符合要求的是括号对
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    // 2、动态规划解
    public int longestValidParenthesesByDp(String s) {
        int max = 0;
        // dp维护一个到当前元素位置最大的有效括号序列长度
        // 如果第i位置的元素为'(' 则dp[i] = 0
        // dp数组非0的位肯定是字符串中为')'的
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) dp[i] = dp[i - 2] + 2;
                    else dp[i] = 2;
                }
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[ i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    // 3、借助栈 O(n)解
    public int longestValidParenthesesByStack(String s) {
        int max = 0;
        if (s.length() == 0 || s.trim().length() == 0) return max;
        Stack<Integer> stack = new Stack<>();
        // 这里的-1是关键，因为每次遇到')'的时候都会进行弹栈操作
        // "))()()" "()"类似这种情况 栈中必须有元素 否则pop的时候会抛出空指针异常
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                // 这里一进来就pop的操作还是挺精髓的 还有就是当遇到')'的时候如何处理栈顶元素是关键
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 如果s以"()"开始 弹栈之后栈中有最初push的-1 这时i = 1时会直接将 '('下标0弹栈
                    // 但是"()"也是有效括号 所以i - (-1) = 2 这时才能够正确计算出有效括号的最大长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // 4、不借助其他存储空间
    // 具体思路 l r分别统计左括号和右括号的数量 每当l == r的时候 则表示当前括号序列有效 这个时候统计最大值
    // 左右分别遍历
    public int longestValidParenthesesByNoUseOtherMem(String s) {
        int l = 0, r = 0, max = 0;
        // 从左向右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') l++;
            else r++;
            if (l == r) max = Math.max(max, 2 * l);
            // 左右遍历这里需要理解
            // 例如这里是从左到右遍历 当右括号数量大于左括号时 就能说明当前序列不是有效序列了
            // 从左到右遍历的时候也是同样道理
            if (r > l) {
                r = 0;
                l = 0;
            }
        }
        l = 0;
        r = 0;
        // 从右向左
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') l++;
            else r++;
            if (l == r) max = Math.max(max, 2 * l);
            if (l > r) {
                r = 0;
                l = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }
}
