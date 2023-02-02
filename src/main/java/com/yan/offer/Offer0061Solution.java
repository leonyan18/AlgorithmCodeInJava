package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 061. 和最小的 k 个数对
 * https://leetcode.cn/problems/qn8gGX/
 */
@Service
public class Offer0061Solution implements Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.add(list);
                while (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        while (queue.size() > 0) {
            ans.add(queue.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
