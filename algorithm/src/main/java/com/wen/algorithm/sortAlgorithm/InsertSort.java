package com.wen.algorithm.sortAlgorithm;

/**
 * 2019.4.11
 *插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array={98,76,109,34,67,190,80,12,14,89,1};

        for(int i=1;i<array.length;i++){//从第2个元素开始循环
            if(array[i] < array[i-1]){
                int temp = array[i];
                int k = i;
                for( int j = i ;j>0 && temp < array[j-1];j--){//移位
                    array[j] = array[j-1];
                    k--;
                }
                array[k] = temp;
            }
        }
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }


    }

}
