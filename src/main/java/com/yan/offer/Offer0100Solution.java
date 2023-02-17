package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 剑指 Offer II 100. 三角形中最小路径之和
 * https://leetcode.cn/problems/IlPe0q/
 */
@Service
public class Offer0100Solution implements Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[2][m];
        for (int i = 0; i < m; i++) {
            List<Integer> temp = triangle.get(i);
            int n = temp.size();
            int pre = (i - 1) % 2;
            int cur = i % 2;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = temp.get(j);
                } else {
                    if (j == n - 1) {
                        dp[cur][j] = dp[pre][j - 1] + temp.get(j);
                    } else if (j == 0) {
                        dp[cur][j] = dp[pre][j] + temp.get(j);
                    } else {
                        dp[cur][j] = Math.min(dp[pre][j - 1], dp[pre][j]) + temp.get(j);
                    }
                }
            }
        }
        List<Integer> temp = triangle.get(m - 1);
        int cur = (m - 1) % 2;
        int ans = dp[cur][0];
        for (int i = 1; i < temp.size(); i++) {
            ans = Math.min(ans, dp[cur][i]);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
