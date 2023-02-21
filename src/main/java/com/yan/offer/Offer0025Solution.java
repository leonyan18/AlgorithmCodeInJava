package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 * https://leetcode.cn/problems/lMSNwu/
 */

public class Offer0025Solution implements Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getlen(l1);
        int len2 = getlen(l2);
        if (len1 >= len2) {
            int val = addTwo(l1, l2, len1, len2);
            if (val > 0) {
                return new ListNode(1, l1);
            }
            return l1;
        } else {
            int val = addTwo(l2, l1, len2, len1);
            if (val > 0) {
                return new ListNode(1, l2);
            }
            return l2;
        }
    }

    public int addTwo(ListNode l1, ListNode l2, int p1, int p2) {
        if (l1 == null) {
            return 0;
        }
        if (p1 > p2) {
            l1.val = l1.val + addTwo(l1.next, l2, p1 - 1, p2);
            if (l1.val >= 10) {
                l1.val -= 10;
                return 1;
            }
            return 0;
        } else {
            l1.val = l1.val + l2.val + addTwo(l1.next, l2.next, p1 - 1, p2 - 1);
            if (l1.val >= 10) {
                l1.val -= 10;
                return 1;
            }
            return 0;
        }
    }

    public int getlen(ListNode l) {
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.next;
        }
        return cnt;
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