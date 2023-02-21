package com.yan.binsearch;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class LeetCode4Solution implements Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int all = len1 + len2;
        if (all % 2 == 1) {
            return binSearchTwo(nums1, nums2, all / 2 + 1) * 1.0d;
        } else {
            return (binSearchTwo(nums1, nums2, all / 2 + 1) * 1.0d + binSearchTwo(nums1, nums2, all / 2)) / 2;
        }
    }

    public int binSearchTwo(int[] nums1, int[] nums2, int target) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l = 0, r = len1 - 1;
        int ans = -1000001;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int pos = binSearch(nums2, nums1[mid]);
            // System.out.println("pos "+pos+" "+mid);
            if (mid + 1 + pos == target) {
                ans = nums1[mid];
                break;
            } else if (mid + 1 + pos < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // System.out.println("target "+target+" "+ans);
        if (ans == -1000001) {
            l = 0;
            r = len2 - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int pos = binSearch(nums1, nums2[mid]);
                // System.out.println("pos "+pos+" "+mid);
                if (mid + 1 + pos == target) {
                    ans = nums2[mid];
                    break;
                } else if (mid + 1 + pos < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        if (ans == -1000001) {
            ans = nums2[l];
        }
        return ans;
    }

    public int binSearch(int nums[], int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
