package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 033. 变位词组
 * https://leetcode.cn/problems/sfvd7V/
 */

public class Offer0033Solution implements Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String tag = new String(ch);
            if (!map.containsKey(tag)) {
                map.put(tag, new LinkedList<>());
            }
            map.get(tag).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsPast(String[] strs) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String s : strs) {
            String tag = makeString(s);
            if (!map.containsKey(tag)) {
                map.put(tag, new LinkedList<String>());
            }
            map.get(tag).add(s);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }

    public String makeString(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.clear();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // System.out.println(map.size());
        String ans = "";
        for (int i = 0; i < 26; i++) {
            String ch = (char) ('a' + i) + "";
            int len = map.getOrDefault(ch, 0);
            for (int j = 0; j < len; j++) {
                ans += ch;
            }
        }
//         System.out.println(ans);
        return ans;
    }

    public boolean isAnagram(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            String ch = t.charAt(i) + "";
            if (!map.containsKey(ch) || map.get(ch) <= 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

    public String makeString2(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        // System.out.println(ans);
        return new String(ch);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        String[] test = {"chi", "nip", "lab", "mud", "fan", "yak", "kid", "lox", "joy", "rob", "cad", "hug", "ken", "oaf", "pus", "hos", "ton", "any", "sac", "mid", "nip", "ron", "tux", "set", "jug", "axe", "ago", "sob", "ode", "dot", "nit", "pug", "sue", "new", "rub", "sup", "ohs", "ski", "oaf", "don", "cob", "kin", "ark", "gay", "jay", "bur", "dot", "eat", "rca", "wad", "maj", "luz", "gad", "dam", "eon", "ark", "del", "sin", "tat"};
        List<List<String>> ans = groupAnagrams(test);
        int cnt = 0;
        for (String s : test) {
            if (!makeString(s).equals(makeString2(s))) {
                System.out.println(makeString(s) + " " + makeString2(s));
            }
        }
        System.out.println("++++++");
        for (List<String> l : ans) {
            cnt += l.size();
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    if (!isAnagram(l.get(i), l.get(j))) {
                        System.out.println(l.get(i) + "" + l.get(j));
                    }
                }
            }
        }
        System.out.println(test.length);
        System.out.println(cnt);
    }
}
