package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 085. 生成匹配的括号
 * https://leetcode.cn/problems/IDBivT/
 */
@Service
public class Offer0085Solution implements Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int[] val = new int[n * 2];
        gen(ans, val, 0, n, n);
        return ans;
    }

    public void gen(List<String> ans, int[] val, int pos, int l, int r) {
        if (l == 0 && r == 0) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < val.length; i++) {
                str.append(val[i] == 1 ? ')' : '(');
            }
            ans.add(str.toString());
        }
        if (l < 0 || r < 0) {
            return;
        }
        if (l < r) {
            val[pos] = 1;
            gen(ans, val, pos + 1, l, r - 1);
        }
        if (l > 0) {
            val[pos] = 0;
            gen(ans, val, pos + 1, l - 1, r);
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
