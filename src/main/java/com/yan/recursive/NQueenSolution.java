package com.yan.recursive;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
 * BM59 N皇后问题
 * https://www.nowcoder.com/practice/c76408782512486d91eea181107293b6
 */
public class NQueenSolution implements Solution {
    /**
     * @param n int整型 the n
     * @return int整型
     */
    int[] row;
    int cnt = 0;

    public int Nqueen(int n) {
        // write code here
        row = new int[n + 5];
        for (int i = 0; i < n; i++) {
            row[i] = 0;
        }
        cnt = 0;
        Set<Integer> set = new HashSet<>(n * 4 + 5);
        doQueen(0, n, set);
        return cnt;
    }

    public void doQueen(int pos, int n, Set<Integer> set) {
        if (pos == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int temp1 = pos - i;
            int temp2 = pos + i + n * 2;
            if (row[i] == 0 && !set.contains(temp1) && !set.contains(temp2)) {
                set.add(temp1);
                set.add(temp2);
                row[i] = 1;
                doQueen(pos + 1, n, set);
                row[i] = 0;
                set.remove(temp1);
                set.remove(temp2);
            }
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}