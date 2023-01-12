package com.yan.greedy;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
 * BM96 主持人调度（二）
 * https://www.nowcoder.com/practice/4edf6e6d01554870a12f218c94e8a299
 */
//@Service
public class BM96Solution implements Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        ArrayList<Node> lists = new ArrayList<Node>(n * 2 + 5);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            lists.add(new Node(startEnd[i][0], true));
            lists.add(new Node(startEnd[i][1], false));
        }
        Collections.sort(lists, (n1, n2) -> {
            if (n1.val == n2.val)
                return n1.start == false && n2.start == true ? 1 : -1;
            return n1.val > n2.val ? 1 : -1;
        });
        int cnt = 0;
        for (int i = 0; i < 2 * n; ) {
            Node temp = null;
            do {
                temp = lists.get(i);
                cnt += temp.start == true ? 1 : -1;
                i++;
            } while (i < n * 2 && temp.val == lists.get(i).val);
            ans = Math.max(cnt, ans);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        int[][] startEnd = new int[100000][2];
        for (int i = 0; i < 100000; i++) {
            startEnd[i][0] = 0;
            startEnd[i][1] = 1;
        }
        System.out.println(minmumNumberOfHost(100000, startEnd));
    }

    class Node {
        int val;
        boolean start;

        public Node(int val, boolean start) {
            this.val = val;
            this.start = start;
        }
    }
}