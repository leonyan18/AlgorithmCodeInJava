package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 074. 合并区间
 * https://leetcode.cn/problems/SsGoHC/
 */

public class Offer0074Solution implements Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int[] pre = new int[2];
        pre[0] = intervals[0][0];
        pre[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = new int[2];
            if (pre[1] < intervals[i][0]) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                list.add(pre[1]);
                ans.add(list);
                pre[0] = intervals[i][0];
                pre[1] = intervals[i][1];
            } else {
                pre[1] = Math.max(intervals[i][1], pre[1]);
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(pre[0]);
        list.add(pre[1]);
        ans.add(list);
        int[][] val = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> temp = ans.get(i);
            val[i][0] = temp.get(0);
            val[i][1] = temp.get(1);
        }
        return val;
    }


    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
