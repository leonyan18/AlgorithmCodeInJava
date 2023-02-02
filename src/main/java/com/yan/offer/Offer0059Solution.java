package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * https://leetcode.cn/problems/jBjn9C/
 */
@Service
public class Offer0059Solution implements Solution {
    class KthLargest {
        PriorityQueue<Integer> queue;
        int len;

        public KthLargest(int k, int[] nums) {
            len = k;
            queue = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
                while (queue.size() > len) {
                    queue.poll();
                }
            }
        }

        public int add(int val) {
            queue.add(val);
            while (queue.size() > len) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
