package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * https://leetcode.cn/problems/SLwz0R/
 */
//@Service
public class Offer0021Solution implements Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        int pos = cnt - n + 1;
        if (pos == 1) {
            return head.next;
        }
        temp = head;
        cnt = 0;
        ListNode pre = head;
        while (temp != null) {
            cnt++;
            if (cnt == pos) {
                pre.next = temp.next;
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
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