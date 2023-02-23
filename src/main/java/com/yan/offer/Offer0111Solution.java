package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 111. 计算除法
 * https://leetcode.cn/problems/vlzXQL/
 */
public class Offer0111Solution implements Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Double> doubleMap = new HashMap<>();
        int cnt = 0;
        int pos = 0;
        for (List<String> equation : equations) {
            for (String s : equation) {
                if (!map.containsKey(s)) {
                    map.put(s, cnt);
                    cnt++;
                }
            }
            int fir = map.get(equation.get(0));
            int sec = map.get(equation.get(1));
            // System.out.println(fir+" "+sec+" "+1.0d/values[pos]);
            doubleMap.put(100 * fir + sec, values[pos]);
            doubleMap.put(100 * sec + fir, 1.0d / values[pos]);
            pos++;
        }
        pos = 0;
        for (List<String> query : queries) {
            boolean[] vis = new boolean[cnt];
            int start = map.getOrDefault(query.get(0), -1);
            int end = map.getOrDefault(query.get(1), -1);
            if (start == -1 || end == -1) {
                ans[pos] = -1.0d;
            } else {
                ans[pos] = dfs(doubleMap, vis, start, end, cnt, 1.0d);
            }
            pos++;
        }
        return ans;
    }

    public double dfs(Map<Integer, Double> doubleMap, boolean[] vis, int start, int end, int size, double now) {
        if (start == end) {
            return now;
        }
        int val = start * 100 + end;
        if (doubleMap.containsKey(val)) {
            // System.out.println(start+" "+end+" "+doubleMap.get(val)*now);
            return doubleMap.get(val) * now;
        }
        for (int i = 0; i < size; i++) {
            int temp = start * 100 + i;
            if (vis[i] || !doubleMap.containsKey(temp)) {
                continue;
            }
            vis[i] = true;
            double ans = dfs(doubleMap, vis, i, end, size, now * doubleMap.get(temp));
            if (ans > 0.0d) {
                return ans;
            }
            vis[i] = false;
        }
        return -1.0d;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
