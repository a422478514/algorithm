package com.daquan.chapter1;

/**
 *有一个字符串,包含十个字符,如果允许按一个字符或者两个字符切分,总共有多少种切分方法？
 * 假设拆的是abcde fghij
 */
public class WordSplit {

    /**
     * 递归函数，这里反向求解，拆到第十个字符时，要么在它前一位拆，要么在它前两位拆
     * 所以拆到第十个字符有多少种拆法=拆到它前一位的拆法+拆到它前两位的拆法，依次递归
     * @param index 是拆分到(剩余)第index个字母的时候，有多少种拆法
     */
    private static int fun(int index){
        //当前拆到最后只剩一个字母
        if(index == 1){
            //那么只剩唯一一种拆法
            return 1;
        }
        //当前拆到最后只剩2个字母
        if(index == 2){
            //那么只剩2种拆法
            return 2;
        }
        return fun(index -1) + fun(index -2);
    }

    public static void main(String[] args) {
        System.out.println(fun(10));
    }
}
