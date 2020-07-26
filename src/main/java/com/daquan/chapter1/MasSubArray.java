package com.daquan.chapter1;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MasSubArray {

    public static int solution(int arr[]){
        //新建一个数组用来保存前n项和最大值
        int []arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        //DP找出元素中
        for (int i = 1; i < arr.length; i++) {
            //判断i前数字是否大于0，如果大于0，则可以加上当前值保存在arr2[i]作为能达到的最大值
            //PS:为什么小于0不考虑呢，因为如果小与0了则加上前面的值只会更小
            if(arr2[i-1] > 0){
                arr2[i] = arr2[i-1]+arr2[i];
            }
        }
        //找出最大值
        int max = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            if( arr2[i] > max){
                max = arr2[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(arr));
    }
}
