package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/**
 * 剑指 Offer II 037. 小行星碰撞
 * https://leetcode.cn/problems/XagZNi/
 */

public class Offer0037Solution implements Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int pos : asteroids) {
            if (stack.empty()) {
                stack.push(pos);
            } else {
                int val = pos;
                while (!stack.empty() && check(stack.peek(), val) != 1001) {
                    val = check(stack.pop(), val);
                }
                if (val != 0) {
                    stack.push(val);
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }

    public int check(int a, int b) {
        if (a < 0) {
            return 1001;
        }
        if (b > 0) {
            return 1001;
        }
        if (Math.abs(a) > Math.abs(b)) {
            return a;
        } else if (Math.abs(a) < Math.abs(b)) {
            return b;
        } else {
            return 0;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
