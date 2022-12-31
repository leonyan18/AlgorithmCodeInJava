package com.yan.greedy;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 *BM94 接雨水问题
 * https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f
 */
//@Service
public class WaterSolution implements Solution {

    public long maxWater(int[] arr) {
        // write code here
        int ans = 0;
        int[] waterl =new int[arr.length+5];
        int[] waterr =new int[arr.length+5];
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(arr[i],max);
            waterl[i]=Math.max(arr[i],max);
        }
        max=0;
        for (int i = arr.length-1; i >= 0; i--) {
            max=Math.max(arr[i],max);
            waterr[i]=Math.max(arr[i],max);
        }
        for (int i=0;i<arr.length;i++){
            ans+=Math.min(waterl[i], waterr[i])-arr[i];
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        int[] arr={3,1,2,5,2,4};
//        int[] arr={10,4,10,10,4};
        System.out.println(maxWater(arr));
    }

}
