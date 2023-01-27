package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 剑指 Offer II 038. 每日温度
 * https://leetcode.cn/problems/iIQa4I/
 */
//@Service
public class Offer0038Solution implements Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            map.put(temperatures[i], i);
            int min = len + 1;
            for (int j = temperatures[i] + 1; j <= 100; j++) {
                if (map.containsKey(j)) {
                    min = Math.min(min, map.get(j));
                }
            }
            if (min == len + 1) {
                ans[i] = 0;
            } else {
                ans[i] = min - i;
            }
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
