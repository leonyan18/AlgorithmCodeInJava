package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 095. 最长公共子序列
 * https://leetcode.cn/problems/qJnOS7/
 */
@Service
public class Offer0095Solution implements Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            char c1 = 0;
            if (i > 0) {
                c1 = text1.charAt(i - 1);
            }
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (c1 == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
