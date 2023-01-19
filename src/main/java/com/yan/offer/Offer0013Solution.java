package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * https://leetcode.cn/problems/O4NDxx/
 */
public class Offer0013Solution implements Solution {
    class NumMatrix {
        int[][] pre;

        public NumMatrix(int[][] matrix) {
            pre = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j == 0) {
                        pre[i][j] = matrix[i][j];
                    } else {
                        pre[i][j] = pre[i][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                if (col1 > 0)
                    ans += pre[i][col2] - pre[i][col1 - 1];
                else
                    ans += pre[i][col2];
            }
            return ans;
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}