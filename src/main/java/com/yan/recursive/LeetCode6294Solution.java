package com.yan.recursive;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 6294. 最大价值和与最小价值和的差值
 * https://leetcode.cn/contest/weekly-contest-328/problems/difference-between-maximum-and-minimum-price-sum/
 */
//@Service
public class LeetCode6294Solution implements Solution {
    Map<Integer, List<Integer>> mapList = new HashMap<>();
    Map<String, Long> edgeMap = new HashMap<>();
    boolean[] flag;

    public long maxOutput(int n, int[][] edges, int[] price) {
        mapList.clear();
        flag = new boolean[n + 5];
        edgeMap.clear();
        for (int i = 0; i < edges.length; i++) {
            if (!mapList.containsKey(edges[i][0])) {
                mapList.put(edges[i][0], new LinkedList<>());
            }
            if (!mapList.containsKey(edges[i][1])) {
                mapList.put(edges[i][1], new LinkedList<>());
            }
            mapList.get(edges[i][0]).add(edges[i][1]);
            mapList.get(edges[i][1]).add(edges[i][0]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!mapList.containsKey(i)) {
                mapList.put(i, new LinkedList<>());
            }
            flag[i] = true;
            ans = Math.max(sum(i, price), ans);
            flag[i] = false;
//            System.out.println(ans);
        }
        return ans;
    }

    public long sum(int n, int[] price) {
        List<Integer> list = mapList.get(n);
        long maxv = 0;
        for (int i = 0; i < list.size(); i++) {
            int next = list.get(i);
            String key = n + "#" + next;
            if (flag[next]) {
                continue;
            }
            if (!edgeMap.containsKey(key)) {
                flag[next] = true;
                long temp = sum(next, price);
                edgeMap.put(key, temp);
                flag[next] = false;
            }
            maxv = Math.max(edgeMap.get(key) + price[next], maxv);
        }
        return maxv;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}};
        int[] price = {9, 8, 7, 6, 10, 5};
        int n = 6;
//        int[][] edges = {{2, 0},{0, 1},{1, 3}};
//        int[] price = {2,3,1,1};
//        int n=4;
//        int[][] edges = {{0, 1}};
//        int[] price = {12,12};
//        int n=2;
        System.out.println(maxOutput(n, edges, price));
    }
}