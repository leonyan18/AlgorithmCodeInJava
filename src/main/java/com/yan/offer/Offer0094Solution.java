package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 094. 最少回文分割
 * https://leetcode.cn/problems/omKAoA/
 */
@Service
public class Offer0094Solution implements Solution {
    public int minCut(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i + 1; j++) {
                if (j <= 1) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) != s.charAt(i - j + 1)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j - 2];
                    }
                }
            }
        }
        int[] cnt = new int[len + 1];
        cnt[0] = 0;
        for (int i = 1; i <= len; i++) {
            cnt[i] = cnt[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                // System.out.print(dp[i-1][i-j]+" ");
                if (dp[i - 1][i - j] == 1) {
                    // System.out.println(j+" "+i+"");
                    cnt[i] = Math.min(cnt[i], cnt[j] + 1);
                }
            }
            // System.out.println();
        }
        return cnt[len] - 1;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
