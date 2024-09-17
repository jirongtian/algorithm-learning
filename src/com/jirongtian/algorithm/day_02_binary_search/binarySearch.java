package com.jirongtian.algorithm.day_02_binary_search;

import java.util.ArrayList;

/**
 * 二分查找
 * @author jirongtian
 */
public class binarySearch {

    public static void main(String[] args) {
       // ArrayList
        int[] arrays = {7,13,21,30,38,44,52,53};
        int target = 53;
        int index = binarySearch(arrays, target);
        System.out.println(index);
    }

    public static int binarySearch(int[] arrays,int target){
        int left = 0;
        int right = arrays.length -1;
        int mid;
        while (left <= right){
            //mid = (left + right)/2;
            //mid = left + (right - left)/2;
            mid = (left + right) >>> 1;
            if(arrays[mid] == target) {
                return mid;
            }
            if (arrays[mid] > target){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
