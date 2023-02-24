package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 115. 重建序列
 * https://leetcode.cn/problems/ur2n8P/
 */
public class Offer0115Solution implements Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int len = nums.length;
        int[] need = new int[len + 1];
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < sequences.length; i++) {
            set.add(sequences[i][0]);
            for (int j = 1; j < sequences[i].length; j++) {
                set.add(sequences[i][j]);
                if (!map.containsKey(sequences[i][j - 1])) {
                    map.put(sequences[i][j - 1], new ArrayList<>());
                }
                map.get(sequences[i][j - 1]).add(sequences[i][j]);
                need[sequences[i][j]]++;
            }
        }
        if (set.size() < len) {
            return false;
        }
        // 一开始就不止一个等于零
        for (int i = 1; i < len; i++) {
            if (need[nums[i]] == 0) {
                return false;
            }
        }
        for (int i = 0; i < len; i++) {
            int now = nums[i];
            // 如果need大于零了 不包含某个子序列
            if (need[now] > 0) {
                return false;
            }
            int flag = 0;
            for (int v : map.getOrDefault(now, new ArrayList<>(1))) {
                need[v]--;
                if (need[v] == 0) {
                    flag++;
                }
            }
            if (flag > 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
