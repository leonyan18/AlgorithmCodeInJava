package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 042. 最近请求次数
 * https://leetcode.cn/problems/H8086Q/
 *
 * @// TODO: 2023/1/27
 * Java实现lower_bound()和upper_bound()
 * https://blog.csdn.net/weixin_39590058/article/details/119632426
 */

public class Offer0042Solution implements Solution {

    class RecentCounter {
        List<Integer> list;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);
            return list.size() - search(0, list.size(), t - 3000);
        }

        public int search(int l, int r, int t) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid) < t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
