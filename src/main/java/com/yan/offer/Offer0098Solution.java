package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 098. 路径的数目
 * https://leetcode.cn/problems/2AoeFn/
 */
@Service
public class Offer0098Solution implements Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        long div = 1;
        for (int i = 0; i < m - 1; i++) {
            ans = ans * (n + i);
            div = div * (i + 1);
            if (ans % div == 0) {
                ans = ans / div;
                div = 1;
            }
        }
        return (int) (ans / div);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
