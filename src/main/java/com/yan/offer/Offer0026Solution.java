package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 026. 重排链表
 * https://leetcode.cn/problems/LGjMqU/
 */
//@Service
public class Offer0026Solution implements Solution {
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int pos = 0;
        while (head != null) {
            map.put(pos, head);
            pos++;
            head = head.next;
        }
        pos--;
        int l = 1;
        int cnt = 1;
        ListNode pre = map.get(0);
        while (l <= pos) {
            int next = 0;
            if (cnt % 2 == 0) {
                next = l;
                l++;

            } else {
                next = pos;
                pos--;
            }
            // System.out.println(next);
            pre.next = map.get(next);
            pre = map.get(next);
            cnt++;
        }
        pre.next = null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}