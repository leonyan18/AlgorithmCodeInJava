package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 093. 最长斐波那契数列
 * https://leetcode.cn/problems/Q91FMA/
 */
@Service
public class Offer0093Solution implements Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxv = 0;
        int[][] dp = new int[len][len];
        map.put(arr[0], 0);
        for (int i = 1; i < len; i++) {
            map.put(arr[i], i);
            for (int j = 0; j < i; j++) {
                int pre = arr[i] - arr[j];
                dp[i][j] = 0;
                if (map.containsKey(pre) && pre < arr[j]) {
                    dp[i][j] = dp[j][map.get(pre)] + 1;
                }
                // System.out.println(i+" "+j+" "+dp[i][j]);
                maxv = Math.max(dp[i][j], maxv);
            }
        }
        return maxv > 0 ? maxv + 2 : 0;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
