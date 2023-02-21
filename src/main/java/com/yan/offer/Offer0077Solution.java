package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 077. 链表排序
 * https://leetcode.cn/problems/7WHec2/
 */

public class Offer0077Solution implements Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int len = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }


    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode newhead = new ListNode();
        ListNode pre = newhead;
        while (head1 != null && head2 != null) {
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
