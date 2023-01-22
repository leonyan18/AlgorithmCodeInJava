package com.yan.week;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 第 329 场周赛
 * https://leetcode.cn/contest/weekly-contest-329/
 */
public class leetCodeWeek329Solution implements Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int cnt = 0;
        int flag = 1;
        while (n > 0) {
            cnt++;
            sum += (n % 10) * flag;
            flag = -flag;
            n = n / 10;
        }
        if (cnt % 2 == 0) {
            sum = -sum;
        }
        return sum;
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }

    public boolean makeStringsEqual(String s, String target) {
        int flag = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                flag++;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                flag++;
                break;
            }
        }
        if (flag == 1) {
            return false;
        } else {
            return true;
        }
    }

    public int minCost(int[] nums, int k) {
        int[] dp = new int[nums.length + 5];
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            int minv = Integer.MAX_VALUE;
            int unique = 0;
            mapping.clear();
            for (int j = i; j > 0; j--) {
                mapping.put(nums[j - 1], mapping.getOrDefault(nums[j - 1], 0) + 1);
                if (mapping.get(nums[j - 1]) == 1) unique++;
                if (mapping.get(nums[j - 1]) == 2) unique--;
                minv = Math.min(dp[j - 1] + i - j - unique + 1, minv);
                // System.out.println("i: "+i+" j: "+j+" unique: "+unique+" minv: "+minv);
            }
            dp[i] = minv + k;
        }
        return dp[nums.length];
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
