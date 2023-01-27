package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * https://leetcode.cn/problems/qIsx9U/
 */
//@Service
public class Offer0041Solution implements Solution {
    class MovingAverage {
        int size;
        Queue<Integer> queue;
        int all;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            queue = new ArrayDeque<>(size);
            all = 0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                all -= queue.poll();
            }
            queue.add(val);
            all += val;
            return all * 1.0 / queue.size();
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
