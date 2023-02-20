package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 105. 岛屿的最大面积
 * https://leetcode.cn/problems/ZL6zAn/
 */
@Service
public class Offer0105Solution implements Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxv = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxv = Math.max(dfs(grid, i, j), maxv);
                }
            }
        }
        return maxv;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (y < 0 || x < 0 || x >= grid.length || y >= grid[x].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        int cnt = 1;
        grid[x][y] = 0;
        cnt += dfs(grid, x + 1, y);
        cnt += dfs(grid, x, y + 1);
        cnt += dfs(grid, x, y - 1);
        cnt += dfs(grid, x - 1, y);
        return cnt;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
