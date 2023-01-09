package com.yan.dynamic;

import java.util.*;


/**
 * BM69 把数字翻译成字符串
 * https://www.nowcoder.com/practice/046a55e6cd274cffb88fc32dba695668
 */
public class BM69Solution {
    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve(String nums) {
        // write code here
        int len = nums.length();
        int[] dp = new int[len + 5];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (nums.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            if (i >= 2) {
                int temp = Integer.valueOf(nums.substring(i - 2, i));
                if (temp <= 26 && temp >= 10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }
}