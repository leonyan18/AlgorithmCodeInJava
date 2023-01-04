package com.yan.linklist;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BM5 合并k个已排序的链表
 * https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6
 */
public class BM2Solution implements Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode root = head;
        ListNode pre = null;
        ListNode next = head;
        ListNode start = null;
        ListNode end = null;
        int pos = 1;
        while (head != null && pos <= n) {
            next = head.next;
            if (pos == m) {
                // System.out.println(pre.val);
                start = pre;
                end = head;
            }
            if (pos == n) {
                end.next = head.next;
            }
            if (pos > m) {
                head.next = pre;
            }
            pre = head;
            head = next;
            pos++;
        }
        //如果m=1 start=null
        if (start != null) {
            start.next = pre;
        } else {
            root = pre;
        }
        return root;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }

    class ListNode {
        int val;
        ListNode next = null;
    }
}