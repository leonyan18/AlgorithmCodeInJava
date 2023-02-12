package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 * https://leetcode.cn/problems/TVdhkn/
 */
@Service
public class Offer0079Solution implements Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] flag = new int[nums.length];
        gen(nums, flag, ans, 0);
        return ans;
    }

    public void gen(int[] nums, int[] flag, List<List<Integer>> ans, int pos) {
        if (pos == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] == 1) {
                    temp.add(nums[i]);
                }
            }
            ans.add(temp);
            return;
        }
        flag[pos] = 0;
        gen(nums, flag, ans, pos + 1);
        flag[pos] = 1;
        gen(nums, flag, ans, pos + 1);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
