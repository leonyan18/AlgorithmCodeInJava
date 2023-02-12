package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * https://leetcode.cn/problems/4sjJUc/
 */
@Service
public class Offer0082Solution implements Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int[] flag = new int[candidates.length + 1];
        Set<String> set = new HashSet<>();
        gen(candidates, flag, ans, set, 0, target);
        return ans;
    }

    public void gen(int[] n, int[] flag, List<List<Integer>> ans, Set<String> set, int pos, int cnt) {
        int len = n.length;
        if (cnt == 0 && pos == len) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < flag[i]; j++) {
                    temp.add(n[i]);
                }
            }
            StringBuilder str = new StringBuilder();
            for (int t : temp) {
                str.append(t);
                str.append(",");
            }
            String tempstr = str.toString();
            if (!set.contains(tempstr)) {
                ans.add(temp);
                set.add(tempstr);
            }
            return;
        }
        if (pos >= len || cnt < 0) {
            return;
        }
        for (int j = 0; j <= 1; j++) {
            flag[pos] = j;
            gen(n, flag, ans, set, pos + 1, cnt - j * n[pos]);
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
