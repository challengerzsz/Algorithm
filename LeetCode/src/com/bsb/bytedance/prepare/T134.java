package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 21:49
 */
public class T134 {

    // 加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // totalTank保存的是走一圈之后所有加油站能加的油和消耗的油做差
        // 即sum(gas[0...i]) - sum(cost[0...i])
        // 因为在循环过程中不会去清空totalTank 所以最后的结果就证明这个用例是不是有解
        // 即使我们更新了起点位置 但是走一圈下来之后totalTank其实是一个定值
        // 只是随着我们寻找起始位置的时候顺便计算了 减少多余的遍历
        int totalTank = 0;
        int curTank = 0;
        int startPosition = 0;

        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            // 当前油箱有多少油
            curTank += gas[i] - cost[i];
            // 如果当前油箱没油了 肯定就到不了i + 1了
            if (curTank < 0) {
                // 选择下一个为起点
                startPosition = i + 1;
                // 重制当前油箱
                curTank = 0;
            }
        }
        return totalTank >= 0 ? startPosition : -1;

    }
}
