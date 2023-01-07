package com.yan.dynamic;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
 * 可以使用递归，但是用了遍历
 * BM76 正则表达式匹配
 * https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4
 */
public class BM76Solution implements Solution {
    /**
     * @param str     string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public boolean match(String str, String pattern) {
        // write code here
        int strlen = str.length();
        int patlen = pattern.length();
        boolean[][] dp = new boolean[patlen + 5][strlen + 5];
        dp[0][0] = true;
        for (int i = 1; i <= strlen; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= patlen; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            } else {
                dp[i][0] = false;
            }
        }
        for (int i = 1; i <= patlen; i++) {
            for (int j = 1; j <= strlen; j++) {
                if (pattern.charAt(i - 1) == '*') {
                    if (dp[i - 2][j] == true) {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] ? (pattern.charAt(i - 2) == '.' || pattern.charAt(i - 2) == str.charAt(j - 1)) : false;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j - 1] ? (pattern.charAt(i - 1) == '.' || pattern.charAt(i - 1) == str.charAt(j - 1)) : false;
                }
            }
        }
        return dp[patlen][strlen];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}