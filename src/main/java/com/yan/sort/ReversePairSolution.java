package com.yan.sort;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;

/**
 * BM20 数组中的逆序对
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5
 */
@Service
public class ReversePairSolution implements Solution {
    public long cnt = 0;
    public long mod = 1000000007;

    public void Merge(int[] array, int[] temp, int l, int r) {
        if(l>=r)
            return;
        int mid=(l+r)/2;
        int pos=l,lpos=l,rpos=mid+1;
        while (lpos<=mid&&rpos<=r) {
           if (array[lpos]<=array[rpos]){
               temp[pos]=array[lpos];
               lpos++;
           }else {
               temp[pos]=array[rpos];
               cnt+=rpos-pos;
               cnt=(cnt+mod)%mod;
               rpos++;
           }
           pos++;
        }
        while(lpos<=mid){
            temp[pos]=array[lpos];
            lpos++;
            pos++;
        }
        while(rpos<=r){
            temp[pos]=array[rpos];
            rpos++;
            pos++;
        }
        for (int i = l; i <= r; i++) {
            array[i]=temp[i];
        }
    }

    public void MergeSort(int[] array, int[] temp, int l, int r) {
        int cnt;
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        MergeSort(array, temp, l, mid);
        MergeSort(array, temp, mid + 1, r);
        Merge(array,temp, l, r);
    }

    public int InversePairs(int[] array) {
        cnt = 0;
        int[] temp = new int[array.length];
        MergeSort(array, temp, 0, array.length - 1);
        return (int) cnt;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        int[] array = {1, 2, 3, 4, 5, 6, -1, 0};
        InversePairs(array);
        System.out.println(cnt);
    }
}
