package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 104. 排列的数目
 * https://leetcode.cn/problems/D0F0SV/
 */

public class Offer0104Solution implements Solution {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (dp[i] != 0 && i + nums[j] <= target) {
                    dp[i + nums[j]] += dp[i];
                }
            }
        }
        return dp[target];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
