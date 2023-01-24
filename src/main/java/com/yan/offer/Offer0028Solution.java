package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 028. 展平多级双向链表
 * https://leetcode.cn/problems/Qv1Da2/
 */
//@Service
public class Offer0028Solution implements Solution {
    public Node flatten(Node head) {
        flattenLast(head);
        return head;
    }

    public Node flattenLast(Node node) {
        Node pre = null;
        Node head = node;
        while (head != null) {
            Node temp = head;
            head = head.next;
            // 有孩子节点
            if (temp.child != null) {
                temp.next = temp.child;
                temp.child.prev = temp;
                Node last = flattenLast(temp.child);
                if (head != null) {
                    last.next = head;
                    head.prev = last;
                }
                pre = last;

            } else {
                pre = temp;
            }
            temp.child = null;
        }
        // System.out.println(pre.val);
        return pre;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}