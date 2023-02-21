package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 027. 回文链表
 * https://leetcode.cn/problems/aMhZSa/
 */

public class Offer0027Solution implements Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int mid = len / 2 + 1;
        p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            // System.out.println(p.val);
            if (cnt >= mid) {
                break;
            }
            p = p.next;
        }
        // System.out.println(p.val);
        p = reverse(p);
        while (p != null) {
            //  System.out.println(p.val);
            if (head.val != p.val) {
                return false;
            }
            head = head.next;
            p = p.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            // System.out.println(node.val);
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
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