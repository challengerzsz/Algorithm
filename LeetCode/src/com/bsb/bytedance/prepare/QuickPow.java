package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-02 16:52
 */
public class QuickPow {

    private long quickPow(int x, int y) {


        if (y == 0) return 1;
        else if ((y & 1) == 1) {
            return x * quickPow(x, y - 1);
        } else {
            long part = quickPow(x, y / 2);
            return part * part;
        }
    }

    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        System.out.println(new QuickPow().quickPow(2,50));
        long now = System.currentTimeMillis();
        System.out.println(now - cur);

        cur = System.currentTimeMillis();
        long x = 2;
        for (int i = 1; i < 50; i++) {
            x = x * 2;
        }
        System.out.println(x);
        now = System.currentTimeMillis();
        System.out.println(now - cur);
    }
}
