package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 * 剑指 Offer II 072. 求平方根
 * https://leetcode.cn/problems/jJ0w9p/
 */
@Service
public class Offer0072Solution implements Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }


    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
