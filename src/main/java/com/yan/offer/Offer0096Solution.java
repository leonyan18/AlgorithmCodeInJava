package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 096. 字符串交织
 * https://leetcode.cn/problems/IY6buf/
 */

public class Offer0096Solution implements Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len2 + len1) {
            return false;
        }
        // System.out.println(len1+" "+len2+" "+len3+" ");
        boolean[][] dp = new boolean[len3 + 1][len2 + 1];
        dp[0][0] = true;
        boolean flagi = true;
        for (int i = 0; i < len3; i++) {
            if (!flagi) {
                break;
            }
            flagi = false;
            for (int j = 0; j <= len2; j++) {
                if (!dp[i][j]) {
                    continue;
                }
                int k = i - j;
                if (j < len2 && s2.charAt(j) == s3.charAt(i)) {
                    flagi = true;
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (k < len1 && s1.charAt(k) == s3.charAt(i)) {
                    flagi = true;
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        return dp[len3][len2];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
