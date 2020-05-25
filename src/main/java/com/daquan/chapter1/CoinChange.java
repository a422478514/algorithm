package com.daquan.chapter1;

/**
 * 你有三种硬币，分别面值2元，5元和7元，每种硬币都有足够多。买一本书需要27元。如何用最少的硬币组合正好付清，不需要对方找钱？
 */
public class CoinChange {

    //递归求解
    public static int fun1(int money){
        //f(27) = min{f(27-2)+1, f(27-5)+1, f(27-7)+1}
        //1、设定边界条件
        //如果剩余钱数小于0，则说明没有刚好付清，违反题目规则
        if(money < 0){
            //这里设置个较大的数字即可
            return 100;
        }
        //如果剩余钱数刚好等于0，则说明上次分配刚好能满足总金额是27的条件
        if(money == 0){
            return 0;
        }
        //如果剩余钱数为2或5或7则本次刚好可以最少1次凑齐
        if(money == 2 || money == 5 || money == 7){
            return 1;
        }

        //2、其它情况，还需继续递归，找到最小的钱数
        //找出当前情况下用2元去凑需要的硬币数
        int min_2 = fun1(money-2)+1;
        //找出当前情况下用5元去凑需要的硬币数
        int min_5 = fun1(money-5)+1;
        //找出当前情况下用7元去凑需要的硬币数
        int min_7 = fun1(money-7)+1;
        //比较以上三种策略，哪个消耗硬币数最少，作为递归的最优解
        int min = Math.min(min_2,min_5);
        min = Math.min(min,min_7);
        return min;
    }

    //动态规划求解
    public static int fun2(){
        //设定钱币种类数组，分别对应2元、5元、7元
        int [] COIN = {2,5,7};
        //设定总金额数组，下标表示金额大小，值表示凑该金额需要的硬币数
        int [] TOTAL = new int[28];
        //初始化金额数组，凑0元需要0个硬币数
        TOTAL[0] = 0;
        for (int i = 1; i < 28; i++) {
            //假定100是最大值
            TOTAL[i] = 100;
        }
        //for循环计算金额数组中每个值需要的硬币数
        for (int i = 1; i < 28; i++) {
            //用三种硬币挨个尝试，能否凑齐该金额
            for (int j = 0; j < COIN.length; j++) {
                //如果通过j能够凑满i
                //这一句最难理解**********************
                // i >= COIN[j]是为了保证避免无意义的对比 比如 i=1 时
                //TOTAL[i - COIN[j]] != 100 是因为如果 该表达式成立，则加上当前硬币(即+1)就可满足凑足金额，
                if(i >= COIN[j] && TOTAL[i - COIN[j]] != 100){
                    TOTAL[i] = Math.min(TOTAL[i - COIN[j]] + 1,TOTAL[i]);
                }
            }
        }
        return TOTAL[27];
    }

    public static void main(String[] args) {
        //System.out.println(fun1(27));
        System.out.println(fun2());
    }
}
