package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;

/**
 * 剑指 Offer II 031. 最近最少使用缓存
 * https://leetcode.cn/problems/OrIXps/
 */
//@Service
public class Offer0031Solution implements Solution {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        System.out.println("test");
        Offer0031Solution lruCacheSolution = new Offer0031Solution(2);
        lruCacheSolution.set(1, 1);
        lruCacheSolution.set(2, 2);
        System.out.println(lruCacheSolution.get(1));
        lruCacheSolution.set(3, 3);
        System.out.println(lruCacheSolution.get(2));
        lruCacheSolution.set(4, 4);
        System.out.println(lruCacheSolution.get(1));
        System.out.println(lruCacheSolution.get(3));
        System.out.println(lruCacheSolution.get(4));
    }

    public Offer0031Solution() {

    }

    public Offer0031Solution(int capacity) {
        this.capacity = capacity;
        // 设置为访问顺序
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        // write code here
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        return val;
    }

    public void set(int key, int value) {
        // 只有大小等于容量并且插入的时候key不存在的时候才进行删除之前的
        if (map.size() == capacity && !map.containsKey(key)) {
            // 删除最远没用过的
            int temp = map.entrySet().iterator().next().getKey();
            map.remove(temp);
        }
        map.put(key, value);
    }
}
