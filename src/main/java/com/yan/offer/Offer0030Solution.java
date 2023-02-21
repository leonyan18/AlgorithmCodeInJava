package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * https://leetcode.cn/problems/FortPu/
 */

public class Offer0030Solution implements Solution {
    class RandomizedSet {
        Map<Integer, Integer> map;
        ArrayList<Integer> list;
        Random random;
        int index;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
            index = 0;
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, index);
            if (index >= list.size()) {
                list.add(val);
            } else {
                list.set(index, val);
            }
            index++;
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int pos = map.get(val);
            int last = list.get(index - 1);
            map.put(last, pos);
            list.set(pos, last);
            index--;
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            // System.out.println(list);
            return list.get(random.nextInt(index));
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}