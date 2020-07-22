package com.daquan.chapter1;

/**
 * 加密字符串，给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，
 * 加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，数组a前三位已经赋值；
 */
public class EncodeString {

    /**
     * 加密
     * @param str
     * @return
     */
    public static String encode(String str){
        //初始化arr数组
        int [] arr = new int[100];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        //初始化arr
        for (int i = 3; i < 100; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        //新的字符串保存加密后的值
        StringBuilder sb = new StringBuilder();
        //迭代str
        for (int i = 0; i < str.length(); i++) {
            sb.append((char)(str.charAt(i)+arr[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("abcde"));
    }
}
