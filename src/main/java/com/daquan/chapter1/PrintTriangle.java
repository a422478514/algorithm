package com.daquan.chapter1;

/**
 * 根据输入的n，打印等腰三角形
 */
public class PrintTriangle {

    public static void print(int n){
        for (int i = 0; i < n; i++) {
            //确定打印"*"的起始位置，其余位置打印" "
            int startPos = n-i-1;
            //这里有个小优化，右侧的空格可以不打
            int endPos = n-i-1+(2*i+1);
            for (int j = 0; j <= endPos; j++) {
                if(j >= startPos && j < endPos){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }


    }

    public static void main(String[] args) {
        print(3);
    }
}
