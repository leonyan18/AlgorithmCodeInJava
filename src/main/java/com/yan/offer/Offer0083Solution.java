package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * https://leetcode.cn/problems/VvJkup/
 */
@Service
public class Offer0083Solution implements Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        gen(nums, ans, 0);
        return ans;
    }

    public void gen(int[] n, List<List<Integer>> ans, int pos) {
        int len = n.length;
        if (pos == len - 1) {
            ans.add(makeList(n));
            return;
        }
        gen(n, ans, pos + 1);
        for (int i = pos + 1; i < len; i++) {
            int temp = n[pos];
            n[pos] = n[i];
            n[i] = temp;
            gen(n, ans, pos + 1);
            n[i] = n[pos];
            n[pos] = temp;
        }
    }

    public List<Integer> makeList(int[] n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            ans.add(n[i]);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
