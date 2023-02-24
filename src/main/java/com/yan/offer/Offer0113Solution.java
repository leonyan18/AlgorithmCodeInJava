package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 113. 课程顺序
 * https://leetcode.cn/problems/QA2IGt/
 */
public class Offer0113Solution implements Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int pos = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] need = new int[numCourses];
        int[] vis = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            // System.out.println(prerequisites[i][1]);
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            need[prerequisites[i][0]]++;
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (need[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            ans[pos++] = top;
            for (int next : map.getOrDefault(top, new ArrayList<Integer>(1))) {
                need[next]--;
                if (need[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (pos == numCourses) {
            return ans;
        }
        return new int[0];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
