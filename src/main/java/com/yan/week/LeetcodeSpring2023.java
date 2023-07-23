package com.yan.week;

import java.util.*;

public class LeetcodeSpring2023 {
    public int rampartDefensiveLine(int[][] rampart) {
        int l = 0;
        int r = 100000000;
        while (l < r) {
            System.out.println(l + " " + r);
            int mid = (r - l) / 2 + l;
            if (check(rampart, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public boolean check(int[][] rampart, int val) {
        int len = rampart.length;
        int pos = rampart[0][1];
        for (int i = 1; i < len; i++) {
            if (pos > rampart[i][0]) {
                return false;
            }
            pos = rampart[i][1] + val - (rampart[i][0] - pos);
        }
        return true;
    }

    /*
    [-1,0,0,1,2,2]
    [-1,0,0,2]
    [-1,0,1,1,2]
    * */
    public String evolutionaryRecord(int[] parents) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < parents.length; i++) {
            List<Integer> list = map.getOrDefault(parents[i], new ArrayList<>());
            list.add(i);
            map.put(parents[i], list);
        }
        return doDfs(map, 0);
    }

    public String doDfs(Map<Integer, List<Integer>> map, int pos) {
//        System.out.println(pos);
        List<String> childs = new ArrayList<>();
        for (Integer v : map.getOrDefault(pos, new ArrayList<>())) {
            childs.add("0" + doDfs(map, v) + "1");
        }
        Collections.sort(childs);
        String ans = "";
        for (int i = 0; i < childs.size(); i++) {
            System.out.println(childs.get(i));
            if (i == childs.size() - 1 && pos == 0) {
                String temp = childs.get(i);
                int end = temp.length() - 1;
                for (; end >= 0; end--) {
                    if (temp.charAt(end) == '0') {
                        end++;
                        break;
                    }
                }
                ans += temp.substring(0, end);
            } else {
                ans += childs.get(i);
            }
        }
        return ans;
    }

}
