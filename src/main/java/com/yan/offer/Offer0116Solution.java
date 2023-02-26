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
                // vis[i]=false;
            }
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
