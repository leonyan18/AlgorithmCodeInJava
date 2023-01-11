package com.yan.string;

import java.util.*;


/**
 * BM85 验证IP地址
 * https://www.nowcoder.com/practice/55fb3c68d08d46119f76ae2df7566880
 */
public class BM85Solution {
    public boolean check(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'f') {
            return true;
        }
        if (c >= 'A' && c <= 'F') {
            return true;
        }
        return false;
    }

    /**
     * 验证IP地址
     *
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve(String IP) {
        // write code here
        if (IP.contains("\\.") && IP.contains(":")) {
            return "Neither";
        }
        if (IP.contains(".")) {
            int cnt = 0;
            for (int i = 0; i < IP.length(); i++) {
                if (IP.charAt(i) == '.') {
                    cnt++;
                }
            }
            if (cnt != 3) {
                return "Neither";
            }
            String[] vals = IP.split("\\.");
            // System.out.println("vals="+vals.length);
            if (vals.length != 4) {
                return "Neither";
            }
            for (String val : vals) {
                // System.out.println(val);
                int v = -1;
                if (val.length() > 1 && val.charAt(0) == '0') {
                    return "Neither";
                }
                try {
                    v = Integer.valueOf(val);
                } catch (Exception e) {
                    return "Neither";
                }
                if (v < 0 || v > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            int cnt = 0;
            for (int i = 0; i < IP.length(); i++) {
                if (IP.charAt(i) == ':') {
                    cnt++;
                }
            }
            if (cnt != 7) {
                return "Neither";
            }
            String[] vals = IP.split(":");
            // System.out.println("vals="+vals.length);
            if (vals.length != 8) {
                return "Neither";
            }
            for (String val : vals) {
                // System.out.println(val);
                if (val.length() > 4 || val.length() == 0) {
                    return "Neither";
                }
                for (int i = 0; i < val.length(); i++) {
                    if (!check(val.charAt(i))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}