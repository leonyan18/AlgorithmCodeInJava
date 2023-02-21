package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * https://leetcode.cn/problems/GzCJIP/
 */

public class Offer0088Solution implements Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= len; i++) {
            int temp = 0;
            if (i < len) {
                temp = cost[i];
            }
            if (dp[i - 1] > dp[i - 2]) {
                dp[i] = dp[i - 2] + temp;
            } else {
                dp[i] = dp[i - 1] + temp;
            }
        }
        return dp[len];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
