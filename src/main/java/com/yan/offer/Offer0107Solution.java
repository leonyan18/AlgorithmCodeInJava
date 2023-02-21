package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 107. 矩阵中的距离
 * https://leetcode.cn/problems/2bCMpM/
 */

public class Offer0107Solution implements Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = top[0] + dir[i][0];
                int y = top[1] + dir[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                    ans[x][y] = ans[top[0]][top[1]] + 1;
                    queue.add(new int[]{x, y});
                    vis[x][y] = true;
                }
            }
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
