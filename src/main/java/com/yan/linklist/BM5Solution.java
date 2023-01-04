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
public class BM5Solution implements Solution {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ArrayList<Integer> vals = new ArrayList<>();
        if (lists.size() == 0) {
            return null;
        }
        for (ListNode l : lists) {
            while (l != null) {
                vals.add(l.val);
                l = l.next;
            }
        }
        if (vals.size() == 0) {
            return null;
        }
        Collections.sort(vals);
        ListNode root = null;
        ListNode pre = root;
        for (int v : vals) {
            ListNode temp = new ListNode(v);
            if (pre == null) {
                root = temp;
            } else {
                pre.next = temp;
            }
            pre = temp;
        }
        return root;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
