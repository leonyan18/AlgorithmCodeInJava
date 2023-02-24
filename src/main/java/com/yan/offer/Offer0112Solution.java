package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer II 112. 最长递增路径
 * https://leetcode.cn/problems/fpTFWP
 */
public class Offer0112Solution implements Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        map.clear();
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int[][] mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (check(matrix, i, j)) {
                    max = Math.max(dfs(matrix, vis, mem, i, j), max);
                }
            }
        }
        return max;
    }

    public boolean check(int[][] matrix, int x, int y) {
        int flag = 0;
        if (x == 0 || matrix[x - 1][y] >= matrix[x][y]) {
            flag++;
        }
        if (y == 0 || matrix[x][y - 1] >= matrix[x][y]) {
            flag++;
        }
        if (x == matrix.length - 1 || matrix[x + 1][y] >= matrix[x][y]) {
            flag++;
        }
        if (y == matrix[x].length - 1 || matrix[x][y + 1] >= matrix[x][y]) {
            flag++;
        }
        return flag == 4;
    }

    public int dfs(int[][] matrix, boolean[][] vis, int[][] mem, int x, int y) {
        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        mem[x][y]++;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || vis[nx][ny] || matrix[x][y] >= matrix[nx][ny]) {
                continue;
            }
            vis[nx][ny] = true;
            mem[x][y] = Math.max(dfs(matrix, vis, mem, nx, ny) + 1, mem[x][y]);
            vis[nx][ny] = false;
        }
        return mem[x][y];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
