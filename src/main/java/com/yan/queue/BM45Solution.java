package com.yan.queue;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * BM45 滑动窗口的最大值
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788
 */
public class BM45Solution implements Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num.length < size) {
            return ans;
        }
        if (size == 0) {
            return ans;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1.val != n2.val) {
                return n1.val > n2.val ? -1 : 1;
            }
            return n1.pos > n2.pos ? 1 : -1;
        });
        int i = 0;
        for (; i < size - 1; i++) {
            queue.add(new Node(num[i], i));
        }
        for (; i < num.length; i++) {
            queue.add(new Node(num[i], i));
            while (queue.peek().pos <= i - size) {
                queue.poll();
            }
            ans.add(queue.peek().val);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }

    class Node {
        int val;
        int pos;

        public Node(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
