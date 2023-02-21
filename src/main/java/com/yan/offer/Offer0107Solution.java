package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 106. 二分图
 * https://leetcode.cn/problems/vEAB3K/
 */

public class Offer0107Solution implements Solution {
    public boolean isBipartite(int[][] graph) {
        byte[] flag = new byte[graph.length + 1];
        boolean[] visit = new boolean[graph.length + 1];
        for (int i = 0; i < graph.length; i++) {
            if (!dfs(graph, flag, visit, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, byte[] flag, boolean[] visit, int pos) {
        if (visit[pos]) {
            return true;
        }
        visit[pos] = true;
        if (flag[pos] == 0) {
            flag[pos] = 1;
        }
        int next = (flag[pos]) % 2 + 1;
        for (int i = 0; i < graph[pos].length; i++) {
            int val = graph[pos][i];
            if (flag[val] == 0) {
                flag[val] = (byte) next;
            }
            if (flag[val] != next) {
                return false;
            }
            if (!dfs(graph, flag, visit, val)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
