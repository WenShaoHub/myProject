package com.wen.algorithm.sortAlgorithm;

/*
归并排序,时间复杂度 O(nlogn)，空间复杂度
 */
public class MergeSort {
    static int n = 0;

    public static void main(String[] args) {
        int[] A = {2,6,7,1,4,9,7,3};
//        int[] B = {1,2,3,4,5,6};

        int[] afterSortA = merge_sort_c(A, 0, A.length - 1);
        for(int a : afterSortA){
            System.out.print(a+",");
        }

    }


    //递归拆分
    public static int[] merge_sort_c(int[] A, int p, int q){
        if(p >= q){
            return new int[]{A[p]};
        }
        int middle = (p+q)/2;
        int[] B = merge_sort_c(A, p, middle);
        System.out.println("====="+n++);
        int[] C = merge_sort_c(A, middle+1, q);
        System.out.println(n++);
        return merge(B,C);
    }
    //合并、排序
    public static int[] merge(int B[],int C[]){
        int A[] = new  int[B.length + C.length];
        int i = 0;
        int j = 0;
        int p = 0;

        while (i < B.length && j < C.length){
            if(B[i] <= C[j]){
                A[p] = B[i];
                p++;
                i++;
            }else{
                A[p] = C[j];
                p++;
                j++;
            }
        }
        /*
        Object src--------原数组
        int srcPos,-------原数组开始位置
        Object dest---------目的数组
        int destPos-------目的数组开始位置
        int length--------要复制的元素个数
         */
        if(i < B.length){
            System.arraycopy(B,i,A,p,B.length-i);
        }
        if(j < C.length){
            System.arraycopy(C,j,A,p,C.length-j);
        }

        return A;

    }

}
