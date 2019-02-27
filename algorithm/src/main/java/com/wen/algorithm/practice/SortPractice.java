package com.wen.algorithm.practice;

import com.wen.algorithm.sortAlgorithm.QuickSort;

public class SortPractice {

    /*
    1、如何用快排思想在O(n)内查找第K大元素？
     */
    public static void main(String[] args) {
        //分区、分治的思想, 将两个分为两部分,
        int A[] = {11,3,7,5,12,6,1,9,8,2,10};
        int max = findMax(A, 0, A.length - 1);
        System.out.println("max="+max);
        for (int a :A){
            System.out.println(a);
        }



    }

    public static int findMax(int A[],int p,int q){
        if(p >= q){
            return A[q];
        }
        int povit = QuickSort.partition(A, p, q);
//        findMax(A,p,povit-1);
        findMax(A,povit+1,q);
        return A[q];
    }

}
