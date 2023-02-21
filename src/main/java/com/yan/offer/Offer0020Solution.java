package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * https://leetcode.cn/problems/a7VOhD/
 */

public class Offer0020Solution implements Solution {
    // todo have a better way
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        dp[len][0] = 0;
        int cnt = 0;
        for (int i = len; i > 0; i--) {
            dp[i][0] = 1;
            for (int j = 1; j + i <= len + 1; j++) {
                if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    if (dp[i + 1][j - 2] == 1 && s.charAt(i - 1) == s.charAt(i + j - 2)) {
                        dp[i][j] = 1;
                        cnt++;
                    }
                }
            }
        }
        return cnt + s.length();
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}