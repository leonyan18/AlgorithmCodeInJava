package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * https://leetcode.cn/problems/4ueAj6/
 */
//@Service
public class Offer0029Solution implements Solution {
    public Node insert(Node head, int insertVal) {
        Node nnode = new Node(insertVal);
        if (head == null) {
            nnode.next = nnode;
            return nnode;
        }
        Node p = head;
        Node pre = null;
        int prev = -1;
        // 找到开始位置
        while (pre == null || p != head) {
            // System.out.println(p.val);
            if (pre != null && prev > p.val) {
                break;
            }
            pre = p;
            prev = p.val;
            p = p.next;
        }
        Node temp = p;
        do {
            if (p.val > insertVal) {
                nnode.next = p;
                pre.next = nnode;
                break;
            }
            pre = p;
            p = p.next;
        } while (p != temp);
        if (p == temp) {
            nnode.next = p;
            pre.next = nnode;
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}