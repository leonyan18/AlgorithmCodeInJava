package com.yan.simulation;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
/**
 * BM101设计LFU缓存结构
 * https://www.nowcoder.com/practice/93aacb4a887b46d897b00823f30bfea1
 */

public class LFUCacheSolution implements Solution {
    private HashMap<Integer, Integer> map;

    private HashMap<Integer, Integer> countMap;

    private HashMap<Integer, Integer> opMap;
    private int capacity;
    private int op;

    private PriorityQueue<Node> queue;

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        LFUCacheSolution lfuCacheSolution = new LFUCacheSolution(3);
        lfuCacheSolution.set(2054879058, -121373736);
        lfuCacheSolution.set(2054879053, -121373736);
        lfuCacheSolution.set(2054879025, -121373736);
        lfuCacheSolution.set(2, 4);
        lfuCacheSolution.set(3, 5);
        System.out.println(lfuCacheSolution.get(2));
        lfuCacheSolution.set(4, 4);
        System.out.println(lfuCacheSolution.get(1));
    }

    public int[] LFU(int[][] operators, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                int temp = get(operators[i][1]);
                arrayList.add(temp);
            }
        }
        int[] d = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            d[i] = arrayList.get(i);
        }
        return d;
    }

    public LFUCacheSolution() {
    }

    public LFUCacheSolution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        countMap = new HashMap<>(capacity);
        opMap = new HashMap<>(capacity);
        queue = new PriorityQueue<>(capacity * 4, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.cnt != o2.cnt) {
                    return o1.cnt - o2.cnt;
                } else {
                    return o1.pos - o2.pos;
                }
            }
        });
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        int cnt = countMap.get(key);
        countMap.put(key, cnt + 1);
        opMap.put(key, op);
        queue.add(new Node(key, cnt + 1, op));
        op++;
        return val;
    }

    public void set(int key, int value) {
        // 只有大小等于容量并且插入的时候key不存在的时候才进行删除之前的
        if (map.size() == capacity && !map.containsKey(key)) {
            // 删除最远没用过的
            Node temp = queue.peek();
            while (!map.containsKey(temp.key) || (temp.pos != opMap.get(temp.key))) {
                queue.poll();
                temp = queue.peek();
            }
            temp=queue.poll();
            map.remove(temp.key);
            countMap.remove(temp.key);
        }
        map.put(key, value);
        countMap.put(key, 1);
        opMap.put(key, op);
        queue.add(new Node(key, 1, op));
        op++;
    }

    class Node  {
        int key;
        int cnt;
        int pos;

        public Node() {
        }

        public Node(int key, int cnt, int pos) {
            this.key = key;
            this.cnt = cnt;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (key != node.key) return false;
            if (cnt != node.cnt) return false;
            return pos == node.pos;
        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + cnt;
            result = 31 * result + pos;
            return result;
        }
    }
}
