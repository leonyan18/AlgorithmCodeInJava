package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 091. 粉刷房子
 * https://leetcode.cn/problems/JEj789/
 */

public class Offer0091Solution implements Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len + 1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i - 1][j];
            }
        }
        return Math.min(Math.min(dp[len][0], dp[len][1]), dp[len][2]);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
