package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/**
 * 剑指 Offer II 040. 矩阵中最大的矩形
 * https://leetcode.cn/problems/PLYXKQ/
 */
//@Service
public class Offer0040Solution implements Solution {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] prec = new int[matrix.length + 1][matrix[0].length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                if (j == 0) {
                    prec[i][j] = matrix[i].charAt(j) - '0';
                } else {
                    prec[i][j] = matrix[i].charAt(j) - '0' + prec[i][j - 1];
                }
                // System.out.print(prec[i][j]+" ");
            }
            // System.out.println();
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                if (matrix[i].charAt(j) == '1') {
                    int preall = 0;
                    int h = matrix[i].length() - 1;
                    for (int k = i; k < matrix.length; k++) {
                        int pre = 0;
                        if (j != 0) {
                            pre = prec[k][j - 1];
                        }
                        preall += pre;
                        while (h >= 0 && prec[k][h] - pre != h - j + 1) {
                            h--;
                        }
                        if (h >= j) {
                            max = Math.max((k - i + 1) * (h - j + 1), max);
                        }
                        // System.out.println(" "+i+" "+j+" "+k+" "+h+" "+preall+" "+max);
                    }
                }
            }
        }
        return max;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
