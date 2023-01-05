package com.yan.string;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * BM22 比较版本号
 * https://www.nowcoder.com/practice/2b317e02f14247a49ffdbdba315459e7
 */
public class BM22Solution implements Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare(String version1, String version2) {
        // write code here
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int len = Math.min(versions1.length, versions2.length);
        int i = 0;
        for (; i < len; i++) {
            int ver1 = Integer.valueOf(versions1[i]);
            int ver2 = Integer.valueOf(versions2[i]);
            System.out.println(ver1 + "  " + ver2);
            if (ver1 > ver2) {
                return 1;
            }
            if (ver1 < ver2) {
                return -1;
            }
        }
        for (; i < versions1.length; i++) {
            int ver = Integer.valueOf(versions1[i]);
            if (ver > 0) {
                return 1;
            }
        }
        for (; i < versions2.length; i++) {
            int ver = Integer.valueOf(versions2[i]);
            if (ver > 0) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
