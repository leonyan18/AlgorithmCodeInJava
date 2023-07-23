package com.yan.week;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] supplyWagon(int[] supplies) {
        int len = supplies.length;
        int[] flag = new int[len];
        for (int i = 0; i < (len + 1) / 2; i++) {
            int minv = Integer.MIN_VALUE;
            int mins = 0;
            int mine = 0;
            for (int j = 0; j < len; j++) {
                int start = j;
                int end = j + 1;
                // 没有抛弃
                if (flag[j] == 0) {
                    while (end < len && flag[end] == 1) {
                        end++;
                    }
                    if (end < len && supplies[start] + supplies[end] < minv) {
                        minv = supplies[start] + supplies[end];
                        mins = start;
                        mine = end;
                    }
                }
                j = end - 1;
            }
            supplies[mins] = minv;
            flag[mine] = 1;
            System.out.println(mine);
        }
        int[] ans = new int[len / 2];
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (flag[i] == 0) {
                ans[pos++] = supplies[i];
            }
        }
        return ans;
    }

    public int adventureCamp(String[] expeditions) {
        int len = expeditions.length;
        Set<String> set = new HashSet<>();
        int maxv = 0;
        int ans = -1;
        for (int i = 0; i < len; i++) {
            String[] sp = expeditions[i].split("->");
            int cnt = 0;
            for (String s : sp) {
                if (s.strip().length() == 0) {
                    continue;
                }
                if (!set.contains(s)) {
                    cnt++;
                    set.add(s);
                }
            }
            if (i >= 1 && maxv < cnt) {
                maxv = cnt;
                ans = i;
            }
        }
        return ans;
    }

    public int fieldOfGreatestBlessing(int[][] forceField) {
        int len = forceField.length;
        HashSet<Node> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(new Node(forceField[i][0] * 10L + forceField[i][2] * 5L, forceField[i][1] * 10L + forceField[i][2] * 5L));
            set.add(new Node(forceField[i][0] * 10L - forceField[i][2] * 5L, forceField[i][1] * 10L + forceField[i][2] * 5L));
            set.add(new Node(forceField[i][0] * 10L - forceField[i][2] * 5L, forceField[i][1] * 10L - forceField[i][2] * 5L));
            set.add(new Node(forceField[i][0] * 10L + forceField[i][2] * 5L, forceField[i][1] * 10L - forceField[i][2] * 5L));
        }
        int maxv = 0;
        for (Node node : set) {
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (node.x <= forceField[i][0] * 10L + forceField[i][2] * 5L && node.x >= forceField[i][0] * 10L - forceField[i][2] * 5L) {
                    if (node.y <= forceField[i][1] * 10L + forceField[i][2] * 5L && node.y >= forceField[i][1] * 10L - forceField[i][2] * 5L) {
                        cnt++;
                    }
                }
            }
            maxv = Math.max(cnt, maxv);
        }
        return maxv;
    }

    class Node {
        long x;
        long y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node temp = (Node) obj;
            return this.x == temp.x && this.y == temp.y;
        }
    }

    public int challengeOfTheKeeper(String[] maze) {
        int m = maze.length;
        int n = maze[0].length();
        int[][] ans = new int[m][n];
        int endx = 0;
        int endy = 0;
        int startx = 0;
        int starty = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
            for (int j = 0; j < n; j++) {
                if (maze[i].charAt(j) == 'T') {
                    endx = i;
                    endy = j;
                } else if (maze[i].charAt(j) == 's') {
                    startx = i;
                    starty = j;
                } else if (maze[i].charAt(j) == '#') {
                    ans[i][j] = -2;
                }
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        ArrayDeque<int[]> queue = new ArrayDeque();
        queue.addLast(new int[]{endx, endy, 0});
        ans[endx][endy] = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dir[i][0];
                int ny = temp[1] + dir[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && ans[nx][ny] == -1) {
                    queue.addLast(new int[]{nx, ny, temp[2] + 1});
                    ans[nx][ny] = temp[2] + 1;
                }
            }
        }
        System.out.println(ans[2][1]);
        boolean[][] flag = new boolean[m][n];

        return dfs(flag, ans, maze, startx, starty);
    }

    public int dfs(boolean[][] flag, int[][] ans, String[] maze, int nowx, int nowy) {
        int m = maze.length;
        int n = maze[0].length();
        if (ans[nowx][nowy] < 0) {
            return -1;
        }
        int ni = m - nowx - 1;
        int nj = n - nowy - 1;
        // 如果一过去就无路可走
        int now = -1;
        if (maze[ni].charAt(nowy) != '#' && ans[ni][nowy] < 0) {
            return -1;
        } else {
            now = Math.max(now, ans[ni][nowy]);
        }
        if (maze[nowx].charAt(nj) != '#' && ans[nowx][nj] < 0) {
            return -1;
        } else {
            now = Math.max(now, ans[nowx][nj]);
        }
        flag[nowx][nowy] = true;
        // 寻找下一个节点不会到不了的节点
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int nx = nowx + dir[i][0];
            int ny = nowy + dir[i][1];
            // 下个位置能够到达
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && ans[nx][ny] > 0 && !flag[nowx][nowy]) {
                now = Math.max(now, dfs(flag, ans, maze, nx, ny));
            }
        }
        return now;
    }
}