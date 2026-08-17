package com.pandus.leetcode.solutions.google;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int s = 1; s <= amount; s++) {
            for (int coin : coins) {
                if (coin <= s) {
                    dp[s] = Math.min(dp[s - coin] + 1, dp[s]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
