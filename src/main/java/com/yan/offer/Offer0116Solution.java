package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 116. 省份数量
 * https://leetcode.cn/problems/bLyHh0/
 */
public class Offer0116Solution implements Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int len = isConnected.length;
        boolean[] vis = new boolean[len];
        int[] ancestor = new int[len];
        for (int i = 0; i < len; i++) {
            if (ancestor[i] == 0) {
                vis[i] = true;
                findAncestor(isConnected, ancestor, vis, i, ++cnt);
            }
        }
        return cnt;
    }

    public void findAncestor(int[][] isConnected, int[] ancestor, boolean[] vis, int pos, int anc) {
        ancestor[pos] = anc;
        for (int i = 0; i < isConnected[pos].length; i++) {
            if (isConnected[pos][i] == 1 && !vis[i]) {
                vis[i] = true;
                findAncestor(isConnected, ancestor, vis, i, anc);
                // 必须不然遍历次数很多
                // vis[i]=false;
            }
        }
    }

    /**
     * 并查集
     */
    public int findCircleNumFloyd(int[][] isConnected) {
        int cnt = 0;
        int len = isConnected.length;
        int[] ancestor = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (isConnected[j][k] == 0 && isConnected[i][k] == 1 && isConnected[i][j] == 1) {
                        isConnected[j][k] = 1;
                        isConnected[k][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (ancestor[i] == 0) {
                cnt++;
                for (int j = 0; j < len; j++) {
                    if (isConnected[i][j] != 0) {
                        ancestor[j] = cnt;
                    }
                }
            }
        }
        return cnt;
    }

    public int findCircleNumDisjoint(int[][] isConnected) {
        int cnt = 0;
        int len = isConnected.length;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    uniont(parent, i, j);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    public int find(int[] parent, int pos) {
        if (parent[pos] == pos) {
            return pos;
        }
        int val = find(parent, parent[pos]);
        parent[pos] = val;
        return val;
    }

    public void uniont(int[] parent, int l, int r) {
        parent[find(parent, r)] = find(parent, l);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
