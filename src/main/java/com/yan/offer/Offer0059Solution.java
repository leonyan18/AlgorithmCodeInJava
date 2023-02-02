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
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // returns true
        myCalendar.book(0, 10); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
        myCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
    }
}
