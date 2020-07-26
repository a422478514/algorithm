package com.daquan.chapter1;

/**
 * 对于一个有n个元素的数组，其中存在一个元素出现的次数大于n/2，请找出该元素。时间复杂度和空间复杂尽可能最优
 */
public class FindNumer {

    public static int solution(int arr[]){
        //初始化一个指示器
        int curNum = arr[0];
        //初始化一个计数器
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            //当前元素与上一个元素相等
            if(curNum == arr[i]){
               cnt++;
            }else{
                //否则
                cnt--;
            }
            if(cnt == 0){
                //重新指向当前元素
                cnt = 1;
                curNum = arr[i];
            }
        }
        return curNum;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,2,2};
        System.out.println(solution(arr));
    }
}
