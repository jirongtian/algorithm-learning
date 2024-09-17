package com.jirongtian.algorithm.day_01_arrays;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_15_TwoSum {
    // 方法一：暴力法，穷举所有两数组合
    public int[] twoSum1(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("输入数组错误");
    }

    // 引用hashmap,先遍历存储到map 再循环一次
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            cache.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int otherValue = target - nums[i];
            if (cache.containsKey(otherValue) && i != cache.get(otherValue)) {
                return new int[]{i, cache.get(otherValue)};
            }
        }
        throw new IllegalArgumentException("输入数组错误");
    }

    // 引用hashmap,一次遍历
    public int[] twoSum3(int[] nums, int target){
        HashMap<Integer,Integer> cache = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int otherValue =  target - nums[i];
            if (cache.containsKey(otherValue)) {
                return new int[] {i,cache.get(otherValue)};
            } else {
                // 将自己的值 和自己的索引存入map
                cache.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("输入数组错误");
    }


    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int[] input2 = {3, 1, 3};
        int target = 9;
        int target2 = 6;
        leetcode_15_TwoSum twoSum = new leetcode_15_TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum3(input, target)));
        System.out.println(Arrays.toString(twoSum.twoSum3(input2, target2)));



        // 定义一个大数组，进行性能测试
        int[] input3 = new int[1000000];
        for (int i = 0; i < input3.length; i++)
            input3[i] = input3.length - i;

        int target3 = 567890;

        // 为了计算程序运行时间，开始计算和计算完成分别计时
        long startTime = System.currentTimeMillis();

        int[] output = twoSum.twoSum3(input3, target3);

        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

        for (int index: output)
            System.out.print(index + "\t");
    }
}
