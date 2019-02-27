package com.wen.algorithm.sortAlgorithm;

/*
快速排序算法
平均复杂度O(nlogn)
最坏情况复杂度：O(n*n)
与归并排序比较，优势：快速排序是原地排序算法，空间复杂度低，
缺点：不稳定，当数组里有两个相同元素时，他们的顺序可能会调换
 */
public class QuickSort {
    public static void main(String[] args) {
        int A[] = {9,8,7,6,5,4,3,2,1};
        quick_sort(A,0,A.length-1);
        for(int a : A){
            System.out.print(a+",");
        }
    }

    public static void quick_sort(int A[],int p,int q){
        if(p >= q){
            return ;
        }
        //获取分区点
        int povit = partition(A, p, q);
        quick_sort(A,p,povit-1);
        quick_sort(A,povit+1,q);
        return;
    }

    //获取分区点，通过游标i将数组分为两个区间，一边大于A[povit],一边小于A[povit]
    public static int partition(int A[],int p,int q){
        int i = p;

        for(int j = p;j < q;j++){
            if(A[j] < A[q]){
                swap(A,i,j);
                i++;
            }
        }
        swap(A,i,q);
        return i;
    }

    //将A[i]和A[j]位置替换
    public static void swap(int A[],int i,int j){
        int a = A[i];
        A[i] = A[j];
        A[j] = a;
    }
}
