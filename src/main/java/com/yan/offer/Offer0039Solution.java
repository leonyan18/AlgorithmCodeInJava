package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 剑指 Offer II 039. 直方图最大矩形面积
 * https://leetcode.cn/problems/0ynMMM/
 */

public class Offer0039Solution implements Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] lmin = new int[len];
        int[] rmin = new int[len];
        Stack<Integer> stackl = new Stack<>();
        Stack<Integer> stackr = new Stack<>();
        for (int i = 0; i < len; i++) {
            int j = len - 1 - i;
            int pre = 0;
            int next = len - 1;
            while (!stackl.empty()) {
                int pos = stackl.peek();
                if (heights[pos] < heights[i]) {
                    pre = pos + 1;
                    break;
                }
                stackl.pop();
            }
            while (!stackr.empty()) {
                int pos = stackr.peek();
                if (heights[pos] < heights[j]) {
                    next = pos - 1;
                    break;
                }
                stackr.pop();
            }
            stackl.push(i);
            stackr.push(j);
            rmin[j] = next;
            lmin[i] = pre;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // System.out.println(heights[i]+" "+rmin[i]+" "+lmin[i]+" ");
            ans = Math.max(heights[i] * (rmin[i] - lmin[i] + 1), ans);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
