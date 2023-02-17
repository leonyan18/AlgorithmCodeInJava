package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 剑指 Offer II 101. 分割等和子集
 * https://leetcode.cn/problems/NUPfPr/
 */
@Service
public class Offer0101Solution implements Solution {
    public boolean canPartition(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i];
        }
        if (cnt % 2 == 1) {
            return false;
        }
        int m = cnt / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = m - nums[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + nums[i]] = true;
                }
                if (dp[m]) {
                    return true;
                }
            }
        }
        return dp[m];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
