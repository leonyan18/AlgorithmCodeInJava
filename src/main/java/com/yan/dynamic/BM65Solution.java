package com.yan.dynamic;

import java.util.*;


/**
 * BM65 最长公共子序列(二)
 * https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11
 */
public class BM65Solution {
    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 5][len2 + 5];
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        String ans = "";
        if (dp[len1][len2] != 0) {
            int pos1 = len1;
            int pos2 = len2;
            while (pos1 > 0 && pos2 > 0) {
                if (s1.charAt(pos1 - 1) == s2.charAt(pos2 - 1)) {
                    pos1--;
                    pos2--;
                    ans += s1.charAt(pos1);
                } else if (dp[pos1 - 1][pos2] >= dp[pos1][pos2 - 1]) {
                    pos1--;
                } else {
                    pos2--;
                }
            }
            return new StringBuffer(ans).reverse().toString();
        } else {
            return "-1";
        }
    }
}