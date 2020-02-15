package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 11:37
 */
public class T223 {

    // 计算两个由4条直线构成的2个矩形减去重叠面积的值
    // ((A, B) (C, D)) ((E, F) (G, H))
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 求第一个矩形的面积
        int height1 = C - A;
        int width1 = D - B;
        int s1 = height1 * width1;

        // 求第二个矩形的面积
        int height2 = G - E;
        int width2 = H - F;
        int s2 = height2 * width2;

        // 没有重叠的情况
        // 其实就是判断两个矩形的位置即可
        if (E >= C || G <= A || F >= D || H <= B) {
            return s1 + s2;
        }

        // 下面就是肯定有重复的情况
        // 确定右边
        int x1 = Math.min(C, G);
        // 确定左边
        int x2 = Math.max(E, A);
        int height3 = x1 - x2;

        // 确定上
        int y1 = Math.min(D, H);
        // 确定下
        int y2 = Math.max(F, B);
        int width3 = y1 - y2;
        int area3 = height3 * width3;

        return s1 + s2 - area3;
    }
}
