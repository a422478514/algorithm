package com.daquan.chapter1;

/**
 * 汉诺塔问题
 */
public class Hanoi {

    public static int step = 1;
    /**
     * 借助b把n从a移到c上
     * @param n
     * @param a
     * @param b
     * @param c
     */
    public static void solution(int n,char a,char b,char c){
        //当n=1时，直接移到c
        if(n == 1){
            System.out.println(String.format("第%d步，%c->%c",step++,a,c));
        }else{
            //把n-1从a通过c移动到b
            solution(n-1,a,c,b);
            //移动n
            System.out.println(String.format("第%d步，%c->%c",step++,a,c));
            //将n-1从b通过a移动到c
            solution(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        solution(n,'a','b','c');
    }
}
