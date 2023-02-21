package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * 剑指 Offer II 073. 狒狒吃香蕉
 * https://leetcode.cn/problems/nZZqjQ/
 */

public class Offer0073Solution implements Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length;
        int l = 1;
        int r = piles[len - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public long check(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }


    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
