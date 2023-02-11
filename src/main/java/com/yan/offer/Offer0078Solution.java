package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 078. 合并排序链表
 * https://leetcode.cn/problems/vvXgSW/
 */
@Service
public class Offer0078Solution implements Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode pre = lists[0];
        for (int i = 1; i < lists.length; i++) {
            pre = merge(pre, lists[i]);
        }
        return pre;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode newhead = new ListNode();
        ListNode pre = newhead;
        while (head1 != null && head2 != null) {
            // System.out.println(head1.val);
            if (head1.val <= head2.val) {
                pre.next = head1;
                pre = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                pre = head2;
                head2 = head2.next;
            }
        }
        if (head2 != null) {
            pre.next = head2;
        } else {
            pre.next = head1;
        }
        return newhead.next;
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
