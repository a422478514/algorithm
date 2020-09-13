package com.daquan.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * 从数组中找出符合其左边数字都比其小 其右边数字都比其大的数字
 */
public class FindQualifiedNumber {

    public static void solution(int nums[]){
        int min = nums[nums.length-1];
        int max = nums[0];
        Set<Integer> leftSet = new HashSet<Integer>();
        leftSet.add(max);
        Set<Integer> rightSet = new HashSet<Integer>();
        rightSet.add(min);
        //1.从左向右找
        for (int i = 1; i < nums.length; i++) {
            //如果左边已遍历数字都比该数字小，则该数字符合条件
            if(nums[i] > max){
                leftSet.add(nums[i]);
                max = nums[i];
            }
        }
        //2.从右向左找
        for (int i = nums.length-2; i >= 0; i--) {
            //如果右边已遍历数字都比该数字大，则该数字符合条件
            if(nums[i] < min){
                rightSet.add(nums[i]);
                min = nums[i];
            }
        }
        //3.求两set交集
        for (Integer i : leftSet){
            if(rightSet.contains(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,9};
        solution(arr);
    }
}
