package com.bsb.leetcode.contest.twentith_double;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 22:58
 */
public class T5324 {


    private int n;
    private int discount;
    private int[] products;
    private int[] prices;
    private int count = 0;

    public T5324(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
    }

    public double getBill(int[] product, int[] amount) {
        double total = 0;
        for (int i = 0; i < product.length; i++) {
            total += prices[product[i] - 1] * amount[i];
        }

        if (this.count == n) {
            this.count = 0;
            return total - (discount * total) / 100;
        }
        this.count++;
        return total;
    }

}
