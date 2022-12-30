package com.yan.greedy;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 *BM95 分糖果问题
 * https://www.nowcoder.com/practice/76039109dd0b47e994c08d8319faa352
 */
@Service
public class CandySolution implements Solution {

    public int candy(int[] arr) {
        // write code here
        int ans = 0;
        int[] candyl=new int[arr.length+5];
        int[] candyr=new int[arr.length+5];
        int pre=arr[0];
        candyl[0]=1;
        candyr[arr.length-1]=1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>pre){
                candyl[i]=candyl[i-1]+1;
            }else {
                candyl[i]=1;
            }
            pre=arr[i];
        }
        pre=arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i]>pre){
                candyr[i]=candyr[i+1]+1;
            }else {
                candyr[i]=1;
            }
            pre=arr[i];
        }
        for (int i=0;i<arr.length;i++){
            ans+=Math.max(candyl[i],candyr[i]);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        int[] arr={9,8,7,6,5,4,3,2,1};
//        int[] arr={10,4,10,10,4};
        System.out.println(candy(arr));
    }

}
