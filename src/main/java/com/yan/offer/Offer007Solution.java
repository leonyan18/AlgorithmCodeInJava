package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * https://leetcode.cn/problems/1fGaJU/
 */
public class Offer007Solution implements Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Long ten5 = 100000L;
        Long ten6 = 1000000L;
        List<List<Integer>> ans = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int val = nums[i] + nums[j];
                int pos = midSearch(nums, 0, nums.length - 1, -val);
                if (pos != -1) {
                    if (pos <= j && j < nums.length - 1 && nums[j + 1] == -val) {
                        pos = j + 1;
                    }
                    if (pos > j) {
                        set.add((nums[i] + ten5) * ten6 * ten6 + (nums[j] + ten5) * ten6 + nums[pos] + ten5);
                    }
                }
            }
        }
        for (Long val : set) {
            List<Integer> list = new ArrayList<>();
            list.add((int) (val % ten6 - ten5));
            val = val / ten6;
            list.add((int) (val % ten6 - ten5));
            val = val / ten6;
            list.add((int) (val % ten6 - ten5));
            ans.add(list);
        }
        return ans;
    }

    int midSearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        if (l == r && nums[r] == target) {
            return r;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return midSearch(nums, l, mid, target);
        } else if (nums[mid] > target) {
            return midSearch(nums, l, mid - 1, target);
        } else {
            return midSearch(nums, mid + 1, r, target);
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}