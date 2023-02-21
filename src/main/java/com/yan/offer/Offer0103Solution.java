package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 103. 最少的硬币数目
 * https://leetcode.cn/problems/gaM7Ch/
 */

public class Offer0103Solution implements Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 2];
        dp[0][0] = 0;
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = 10001;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (dp[i - 1][j] == 10001) {
                    continue;
                }
                int time = 1;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                long val = j + (long) time * coins[i - 1];
                while (val <= amount) {
                    int temp = time * coins[i - 1] + j;
                    dp[i][temp] = Math.min(dp[i][temp], dp[i - 1][j] + time);
                    time++;
                    val = (long) time * coins[i - 1] + j;
                }
            }
        }
        return dp[coins.length][amount] == 10001 ? -1 : dp[coins.length][amount];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
