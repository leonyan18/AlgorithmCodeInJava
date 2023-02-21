package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * https://leetcode.cn/problems/Ygoe9J/
 */

public class Offer0081Solution implements Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] flag = new int[candidates.length];
        gen(candidates, flag, ans, 0, target);
        return ans;
    }

    public void gen(int[] n, int[] flag, List<List<Integer>> ans, int pos, int cnt) {
        int len = n.length;
        if (cnt == 0 && pos == len) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < flag[i]; j++) {
                    temp.add(n[i]);
                }
            }
            ans.add(temp);
            return;
        }
        if (pos >= len || cnt < 0) {
            return;
        }
        for (int j = 0; j * n[pos] <= cnt; j++) {
            flag[pos] = j;
            gen(n, flag, ans, pos + 1, cnt - j * n[pos]);
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
