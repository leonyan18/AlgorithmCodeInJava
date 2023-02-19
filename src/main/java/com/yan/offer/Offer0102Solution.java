package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 102. 加减的目标值
 * https://leetcode.cn/problems/YaVDxD/
 */
@Service
public class Offer0102Solution implements Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][40001];
        dp[0][20000 + nums[0]]++;
        dp[0][20000 - nums[0]]++;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 40000; j++) {
                if (dp[i - 1][j] > 0) {
                    dp[i][j + nums[i]] += dp[i - 1][j];
                    dp[i][j - nums[i]] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][20000 + target];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
