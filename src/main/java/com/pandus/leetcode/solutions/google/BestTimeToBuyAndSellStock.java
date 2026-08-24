package com.pandus.leetcode.solutions.google;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buyPrice < ans) {
                buyPrice = Math.min(prices[i], buyPrice);
            }
            ans = Math.max(ans, prices[i] - buyPrice);
        }
        return ans;
    }
}
