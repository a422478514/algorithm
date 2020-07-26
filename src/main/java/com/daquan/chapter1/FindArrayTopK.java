package com.daquan.chapter1;

/**
 * 从两个无序数组中找出topK
 */
public class FindArrayTopK {

    /**
     * 利用选择排序的思想可以实现 k*n的时间复杂度
     * @param arr_1
     * @param arr_2
     * @param k
     * @return
     */
    public static int[] solution(int arr_1[],int arr_2[],int k){
        int a1_size = arr_1.length;
        int a2_size = arr_2.length;

        //对arr_1做选择排序
        selectSort(arr_1,k);
        //对arr_2做选择排序
        selectSort(arr_2,k);

        //输出前k个数
        int x = 0;
        int y = 0;
        for (int i = 0; i < k; i++) {
            if(arr_1[x] >= arr_2[y]){
                System.out.println(arr_1[x]);
                x++;
            }else{
                System.out.println(arr_2[y]);
                y++;
            }
        }

        return null;
    }

    /**
     * 选择排序
     * @param arr
     * @param k
     */
    public static void selectSort(int arr[],int k){
        //对arr_2做选择排序
        for (int i = 0; i < k; i++) {
            int max = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            //交换 max 和 i
            if(max != i){
                int temp = arr[max];
                arr[max] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {-1,6,9,3,7,10,77};
        int arr2[] = {99,2,8,66,33,22,11};
        solution(arr1,arr2,3);
    }
}
