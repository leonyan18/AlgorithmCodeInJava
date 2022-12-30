package com.yan.simulation;

import com.yan.base.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
/**
 * BM100设计LRU缓存结构
 * https://www.nowcoder.com/practice/5dfded165916435d9defb053c63f1e84
 */
//@Service
public class LRUCacheSolution implements Solution {
    private LinkedHashMap<Integer,Integer> map;
    private int capacity;
    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        System.out.println("test");
        LRUCacheSolution lruCacheSolution=new LRUCacheSolution(2);
        lruCacheSolution.set(1,1);
        lruCacheSolution.set(2,2);
        System.out.println(lruCacheSolution.get(1));
        lruCacheSolution.set(3,3);
        System.out.println(lruCacheSolution.get(2));
        lruCacheSolution.set(4,4);
        System.out.println(lruCacheSolution.get(1));
        System.out.println(lruCacheSolution.get(3));
        System.out.println(lruCacheSolution.get(4));
    }
    public LRUCacheSolution() {

    }
    public LRUCacheSolution(int capacity) {
        this.capacity=capacity;
        // 设置为访问顺序
        map= new LinkedHashMap<>(capacity,0.75f,true);
        // write code here
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        int val=map.get(key);
        return val;
    }

    public void set(int key, int value) {
        // 只有大小等于容量并且插入的时候key不存在的时候才进行删除之前的
        if(map.size()==capacity&&!map.containsKey(key)){
            // 删除最远没用过的
            int temp= map.entrySet().iterator().next().getKey();
            map.remove(temp);
        }
        map.put(key,value);
    }
}
