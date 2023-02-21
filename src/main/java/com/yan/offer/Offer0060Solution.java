package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 * https://leetcode.cn/problems/g5c51o/
 */

public class Offer0060Solution implements Solution {
    Map<Integer, Integer> map;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return map.getOrDefault(o1, 0) - map.getOrDefault(o2, 0);
        });
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.add(e.getKey());
            while (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        int pos = 0;
        while (queue.size() > 0) {
            ans[pos++] = queue.poll();
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
