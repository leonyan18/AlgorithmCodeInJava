package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 090. 环形房屋偷盗
 * https://leetcode.cn/problems/PzWKhm/
 */

public class Offer0090Solution implements Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[][][] dp = new int[len + 1][2][2];
        dp[0][0][0] = 0;
        dp[0][1][1] = nums[0];
        if (len == 1) {
            return nums[0];
        }
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                dp[i][0][0] = 0;
                dp[i][0][1] = nums[0];
                dp[i][1][1] = 0;
                dp[i][1][0] = nums[1];
            } else {
                dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
                dp[i][1][0] = dp[i - 1][0][0] + nums[i];
                dp[i][1][1] = dp[i - 1][0][1] + nums[i];
            }
        }
        return Math.max(dp[len - 1][0][1], Math.max(dp[len - 1][0][0], dp[len - 1][1][0]));
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
