package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 16:43
 */
public class T440 {

    // 1 ～ n 字典序第k小的数字 hard
    // 明白以1为前缀的所有不大于n的字典序数字 < 以2为前缀的所有不大于n的字典序数字...以此类推
    // 统计以每个数字为前缀的字典序数字个数 得到第k小的字典序数字

    public int findKthNumber(int n, int k) {
        // 这里因为cur是1 直接算第一小的字典序
        int cur = 1;
        // k--的目的也是因为包含了1是第一小的数字
        // 如果k是1的话 那么结果也就是1 和n无关
        k--;
        while (k > 0) {
            // first和next每次都需要*10 用long保存 防止溢出
            // first其实是一个前缀 next是一个大于first所有子串的前缀
            // 例如first = 1 next = 2
            // first = 10 next = 20
            long count = 0, first = cur, next = cur + 1;
            // 这里就是在找以first为前缀的且不大于n的有多少个
            // 例如n = 13 那么count最终就是5
            while (first <= n) {
                count += Math.min(next, (long) (n + 1)) - first;
                first *= 10;
                next *= 10;
            }

            // 这里的意思就是下一步找以first * 10为前缀的个数
            // 因为以first开头的个数大于k了
            // 所以想象一棵前缀树 就是需要向下递归找下一层的子节点个数
            // 这里的话就是找10为前缀的个数
            // 因为这里其实模拟的就是前缀树递归下降搜索的过程
            // 下降一层就证明确定了一个较小的值
            // k--
            // 到while的时候k == 0 其实也就是找到了10就是1～13中第2小的数字
            if (count > k) {
                k--;
                cur *= 10;
            }
            if (count <= k) {
                k -= count;
                ++cur;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        new T440().findKthNumber(13, 2);
    }

}
