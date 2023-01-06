package com.yan.dynamic;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
 * BM75 编辑距离(一)
 * https://www.nowcoder.com/practice/6a1483b5be1547b1acd7940f867be0da
 */
public class BM75Solution implements Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return int整型
     */
    public int editDistance(String str1, String str2) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 5][len2 + 5];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}