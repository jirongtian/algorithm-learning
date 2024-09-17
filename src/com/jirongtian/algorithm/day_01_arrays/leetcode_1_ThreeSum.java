package com.jirongtian.algorithm.day_01_arrays;

import java.util.*;

public class leetcode_1_ThreeSum {
    // 方法一：暴力法
    public List<List<Integer>> threeSum1(int[] nums){
        int length = nums.length;
        // 定义结果列表
        List<List<Integer>> result = new ArrayList<>();
        // 三层for循环
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(List.of(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return result;
    }

    // 方法二：使用哈希表保存结果 (有问题 想解决很麻烦)
    public List<List<Integer>> threeSum2(int[] nums){
        int length = nums.length;
        // 定义结果列表
        List<List<Integer>> result = new ArrayList<>();
        // 使用cache缓存
        //1（定义一个map，其中map的key 为两数之和， value为 List<List<integer>结构，内容为两数之和相加为key的组合）
        HashMap<Integer,List<List<Integer>>> cache = new HashMap<>();
        // 2.遍历数组， 同时 计算一下 0-当前对象的值，然后查询map中是否存在对于的key，存在的话将List<List<integer>> 取出，
        // 构造新的List<List<integer>> 并add到result
        // 3. 继续构造新的mapKey(即 0到当前索引的两数之和及 List<List<integer>>) 并put到cache

        for (int i = 0; i < length; i++) {
            int target = -nums[i];
            if (cache.containsKey(target)) {
                //后续要去重
                List<List<Integer>> value = cache.get(target);
                for (List<Integer> integers : value) {
                    List<Integer> res = new ArrayList<>(integers);
                    res.add(nums[i]);
                    result.add(res);
                }
            }
            //继续构造新的mapKey
            for (int j = 0; j < i; j++) {
                Integer newKey = nums[i] + nums[j];
                List<List<Integer>> lists = cache.getOrDefault(newKey,new ArrayList<>());
                lists.add(Arrays.asList(nums[i],nums[j]));
                cache.put(newKey,lists);
            }
        }
        return result;
    }

    // 方法三：双指针法
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        // 0. 先对数组排序
        Arrays.sort(nums);

        // 手敲

        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};

        leetcode_1_ThreeSum threeSum = new leetcode_1_ThreeSum();

        System.out.println(threeSum.threeSum1(input));

    }
}
