package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 110. 所有路径
 * https://leetcode.cn/problems/bP4bmD/
 */
public class Offer0110Solution implements Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> now = new LinkedHashSet<Integer>();
        now.add(0);
        dfs(graph, ans, now, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, List<List<Integer>> ans, Set<Integer> now, int pos, int target) {
        if (target == pos) {
            List<Integer> temp = new ArrayList<Integer>(now);
            ans.add(temp);
            return;
        }
        for (int i = 0; i < graph[pos].length; i++) {
            int next = graph[pos][i];
            if (!now.contains(next)) {
                now.add(next);
                dfs(graph, ans, now, next, target);
                now.remove(next);
            }
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
