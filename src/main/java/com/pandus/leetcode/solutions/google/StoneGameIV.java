package com.pandus.leetcode.solutions.google;

public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;

        for (int i = 1; i <= n; i++) {
            int k = 1;
            while (k * k <= i) {
                if (dp[i - k * k] == false) {
                    dp[i] = true;
                    break;
                }
                k++;
            }
        }
        return dp[n];
    }
}
