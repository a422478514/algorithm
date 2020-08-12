package com.daquan.chapter1;

/**
 * 加油站 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 输入: gas = [1,2,3,4,5] cost = [3,4,5,2,2]
 */
public class GasStation {

    public static int solution(int []gas,int []cost){
        //有多少个汽油站
        int gasNum = gas.length;
        //1.计算当前从第k个加油站出发
        for(int k = 0; k < gasNum ; k++){
            //当前汽车汽油数量
            int curGas = 0;
            //标记循环次数，应等于汽油站个数
            int flag = 0;
            //2.从第k个加满油后是否能到达下一加油站
            for(int i = k; flag++ < gasNum ; i++){
                //3.计算出想到达第i个站需要耗费的油，并判断是否能到达第i个站
                //4.第一站只加油不耗油，会跳过判断
                if(i != k){
                    //5.到达当前加油站需要消耗cost[i-1]油
                    curGas -= cost[(i-1)%gasNum];
                    System.out.println("k="+k+" i="+i+" curGas="+curGas);
                    if( curGas < 0){
                        break;
                    }
                }
                //6.如果能到第i个站，则应+当前站里的汽油数
                curGas += gas[i%gasNum];
                System.out.println("k="+k+" i="+i+" curGas="+curGas);
            }
            System.out.println("k="+k+" flag:"+flag+" gasNum:"+gasNum);
            System.out.println("-----------------");
            //如果能跑满gasNum个汽油站，则成功
            if(flag >= gasNum){
                return k;
            }
        }
        return -1;
    }

    //gas = [1,2,3,4,5] cost = [3,4,5,2,2]

    public static void main(String[] args) {
        int []gas = {1,2,3,4,5};
        int []cost = {3,4,5,2,2};
        int result = solution(gas,cost);
        System.out.println(result);
    }
}
