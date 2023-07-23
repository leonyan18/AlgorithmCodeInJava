package com.yan.test;

import java.util.*;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] flag = new boolean[n + 1];
        int cnt = 0;
        for (int i = 1; ; i += k) {
            if (flag[(i % n) + 1]) {
                break;
            }
            flag[(i % n) + 1] = true;
            cnt++;
        }
        System.out.println(cnt);
        int[] ans = new int[n - cnt];
        int pos = 0;
        for (int i = 1; i <= n; i++) {
            if (flag[i]) {
                ans[pos++] = i;
            }
        }
        return ans;
    }

    public boolean doesValidArrayExist(int[] derived) {
        int len = derived.length;
        int val = 1;
        for (int i = 0; i < len; i++) {
            if (derived[i] == 1) {
                val = ~val;
            }
        }
        return val == 1;
    }

    int[] dirX = {1, 0, -1};
    int[] dirY = {1, 1, 1};
    int ans = 0;

    public int maxMoves(int[][] grid) {
        ans = 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for (int j = 0; j < grid.length; j++) {
            int val = find(flag, grid, j, 0);
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public int find(boolean[][] flag, int[][] grid, int x, int y) {
        flag[x][y] = true;
        int maxv = 0;
        for (int i = 0; i < 3; i++) {
            int nx = dirX[i] + x;
            int ny = dirY[i] + y;
            if (nx < grid.length && nx >= 0 && ny < grid[0].length && ny >= 0 && grid[x][y] < grid[nx][ny] && !flag[nx][ny]) {
                maxv = Math.max(find(flag, grid, nx, ny) + 1, maxv);
            }
        }
        return maxv;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int cnt = 0;
        int[] parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Set<Integer> edgeSet = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            union(parent, edges[i][0], edges[i][1]);
            edgeSet.add(edges[i][0] * 100 + edges[i][1]);
            edgeSet.add(edges[i][1] * 100 + edges[i][0]);
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            set.add(parent[i]);
            List<Integer> list = map.getOrDefault(parent[i], new ArrayList<>());
            list.add(i);
            map.put(parent[i], list);
        }
        for (int key : set) {
            System.out.println(key);
            if (check(map.get(key), edgeSet)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean check(List<Integer> list, Set<Integer> edgeSet) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int val = list.get(i) * 100 + list.get(j);
                if (!edgeSet.contains(val)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int find(int[] parent, int pos) {
        if (parent[pos] == pos) {
            return pos;
        }
        int val = find(parent, parent[pos]);
        parent[pos] = val;
        return val;
    }

    public void union(int[] parent, int l, int r) {
        parent[find(parent, r)] = find(parent, l);
    }
}