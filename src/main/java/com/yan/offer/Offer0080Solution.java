package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * https://leetcode.cn/problems/uUsW3B/
 */

public class Offer0080Solution implements Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] flag = new int[n + 1];
        gen(n, flag, ans, 1, k);
        return ans;
    }

    public void gen(int n, int[] flag, List<List<Integer>> ans, int pos, int cnt) {
        // System.out.println(pos+" "+cnt);
        if (cnt == 0 && pos == n + 1) {
            // System.out.println(pos);
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (flag[i] == 1) {
                    temp.add(i);
                }
            }
            ans.add(temp);
            return;
        }
        if (pos > n || cnt < 0) {
            return;
        }
        flag[pos] = 0;
        gen(n, flag, ans, pos + 1, cnt);
        flag[pos] = 1;
        gen(n, flag, ans, pos + 1, cnt - 1);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
