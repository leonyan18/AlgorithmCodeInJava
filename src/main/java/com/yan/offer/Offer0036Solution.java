package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer II 036. 后缀表达式
 * https://leetcode.cn/problems/8Zf90G/
 */

public class Offer0036Solution implements Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            int l = 0;
            int r = 0;
            int val = 0;
            if (s.length() == 1 && (s.charAt(0) < '0' || s.charAt(0) > '9')) {
                r = stack.pop();
                l = stack.pop();
            } else {
                val = Integer.valueOf(s);
            }
            switch (s) {
                case "+":
                    val = l + r;
                    break;
                case "-":
                    val = l - r;
                    break;
                case "*":
                    val = l * r;
                    break;
                case "/":
                    val = l / r;
                    break;
                default:
                    break;
            }
            stack.push(val);
        }
        return stack.pop();
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
