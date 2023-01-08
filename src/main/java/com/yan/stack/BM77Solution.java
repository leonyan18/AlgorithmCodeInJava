package com.yan.stack;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/**
 * BM77 最长的括号子串
 * https://www.nowcoder.com/practice/45fd68024a4c4e97a8d6c45fc61dc6ad
 */
public class BM77Solution implements Solution {
    public int longestValidParentheses(String s) {
        // write code here
        int[] dp = new int[s.length() + 5];
        Stack<Integer> stack = new Stack<>();
        int maxc = 0;
        int cnt = 0;
        dp[s.length()] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    dp[i] = 0;
                } else {
                    dp[i] = 1;
                    dp[stack.pop()] = 1;
                }
            } else {
                dp[i] = 0;
                stack.add(i);
            }
        }
        for (int i = 0; i <= s.length(); i++) {
            // System.out.println(dp[i]);
            cnt += dp[i];
            if (dp[i] == 0) {
                maxc = Math.max(cnt, maxc);
                cnt = 0;
            }
        }
        return maxc;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
