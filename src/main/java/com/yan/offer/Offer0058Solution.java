package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 剑指 Offer II 058. 日程表
 * https://leetcode.cn/problems/fi9suh/
 */
@Service
public class Offer0058Solution implements Solution {
    class MyCalendar {
        List<Integer> starts;
        List<Integer> ends;

        public MyCalendar() {
            starts = new ArrayList<>();
            ends = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int pos = starts.size();
            int preEnd = 0;
            for (int i = 0; i < starts.size(); i++) {
                if (starts.get(i) >= end && preEnd <= start) {
                    pos = i;
                    break;
                }
                preEnd = ends.get(i);
            }
            // System.out.println(pos);
            if (pos == starts.size()) {
                if (ends.size() == 0 || ends.get(pos - 1) <= start) {
                    starts.add(start);
                    ends.add(end);
                    return true;
                } else {
                    return false;
                }
            } else {
                starts.add(pos, start);
                ends.add(pos, end);
                return true;
            }
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // returns true
        myCalendar.book(0, 10); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
        myCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
    }
}
