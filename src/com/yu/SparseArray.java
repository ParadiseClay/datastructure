package com.yu;

/**
 * 棋盘二维数组与稀疏数组的转化
 */

import java.lang.reflect.Array;

public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘二维数组 0代表无子，1代表黑子，2代表白子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2]=1;
        chessArray1[2][3]=2;
        chessArray1[4][5]=2;
        //打印遍历,并计算有效数字的个数
        int sum=0;
        for ( int aArray[]:chessArray1) {
            for (int data:aArray) {
                if (data!=0){
                    sum++;
                }
                System.out.print("\t"+data);
            }
            System.out.println();
        }
        System.out.println("有效数字的个数为："+sum);

        //将棋盘二维数组转化为稀疏数组
        //创建稀疏数组并赋值
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        int count=0;

        for(int i=0;i<chessArray1.length;i++){
            for (int j=0;j<chessArray1.length;j++){
                if(chessArray1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArray1[i][j];

                }
            }
        }
        System.out.println("------------------------------------------------");
        //遍历稀疏数组
        for ( int aArray[]:sparseArray) {
            for (int data:aArray) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
        //将稀疏数组复盘为二维数组，先创建二维数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        //遍历稀疏数组对棋盘二维数组赋值
        for(int i=1;i<sparseArray.length;i++){
            for(int j=0;j<sparseArray.length;j++){
                chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
            }
        }
        //遍历chessArray2
        //遍历稀疏数组
        for ( int aArray[]:chessArray2) {
            for (int data:aArray) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }


    }

}
