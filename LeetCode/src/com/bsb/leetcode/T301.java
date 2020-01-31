package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 22:01
 */
public class T301 {

    // 删除最小数量的无效括号
    // 使其成为有效括号对
    // 可能有不同结果
    // 这题有点难 明天完善..
    private Set<String> set = new HashSet<>();
    private int minCount;

    /**
     * 这个题目需要考虑的东西还是挺多的，不仅需要考虑生成最终的括号对有效
     * 还需要考虑例如删除k个括号后 可能结果是一样的
     * 这个解属于基本回溯
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {

        this.reset();
        this.helper(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.set);
    }

    private void reset() {
        this.set.clear();
        this.minCount = Integer.MAX_VALUE;
    }

    private void helper(String s, int index, int leftCount, int rightCount, 
                         StringBuilder expression, int removedCount) {
        if (index == s.length()) {
            // 当前字符串合法
            if (leftCount == rightCount) {
                // 判断是不是删除最小数量的括号 注意这里是<= 因为可能删除k个括号会有不同结果
                // 这里还是需要注意的 因为题目意思就是要告诉我们这个
                if (removedCount <= this.minCount) {
                    String possibleAnswer = expression.toString();

                    // 如果确实是最小删除 更新全局最小删除变量
                    if (removedCount < this.minCount) {
                        this.set.clear();
                        this.minCount = removedCount;
                    }
                    // 向set添加 避免重复
                    this.set.add(possibleAnswer);
                }
            }
        } else {

            char currentCharacter = s.charAt(index);
            int length = expression.length();

            // 如果该字符不是()直接向表达式添加就好 并且向右继续递归
            if (currentCharacter != '(' && currentCharacter != ')') {
                expression.append(currentCharacter);
                // 向右递归
                this.helper(s, index + 1, leftCount, rightCount, expression, removedCount);
                // 回溯
                expression.deleteCharAt(length);
            } else {
                
                this.helper(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                expression.append(currentCharacter);

                // 如果是左括号就考虑进来 向右继续递归
                if (currentCharacter == '(') {
                    this.helper(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    // 为了保证括号有效必须 右括号小于左括号时才继续向右递归
                    this.helper(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }
                // 回溯
                expression.deleteCharAt(length);
            }
        }
    }


}
