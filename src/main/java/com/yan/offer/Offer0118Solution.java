package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 118. 多余的边
 * https://leetcode.cn/problems/7LpjUW/
 */
public class Offer0118Solution implements Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            if (find(parent, edges[i][0]) == find(parent, edges[i][1])) {
                return edges[i];
            }
            union(parent, edges[i][0], edges[i][1]);
        }
        return edges[len - 1];
    }

    public void union(int[] parent, int l, int r) {
        parent[find(parent, r)] = find(parent, l);
    }

    public int find(int[] parent, int l) {
        if (l != parent[l]) {
            parent[l] = find(parent, parent[l]);
        }
        return parent[l];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
