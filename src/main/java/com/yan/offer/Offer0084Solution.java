package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * https://leetcode.cn/problems/7p8L0Z/
 */

public class Offer0084Solution implements Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        gen(nums, ans, set, 0);
        return ans;
    }

    public void gen(int[] n, List<List<Integer>> ans, Set<List<Integer>> set, int pos) {
        int len = n.length;
        if (pos == len - 1) {
            List<Integer> now = makeList(n);
            if (!set.contains(now)) {
                set.add(now);
                ans.add(now);
            }
            return;
        }
        gen(n, ans, set, pos + 1);
        for (int i = pos + 1; i < len; i++) {
            if (n[i] == n[pos]) {
                continue;
            }
            int temp = n[pos];
            n[pos] = n[i];
            n[i] = temp;
            gen(n, ans, set, pos + 1);
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
