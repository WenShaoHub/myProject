package com.wen.algorithm.tree;

public class TreeMain {



    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodeArray = {1,2,9,3,4,8,10,5,6,7};
        tree.setNodeArray(nodeArray);
        tree.buildSearchTree();
        tree.toString();
        //先序遍历

        tree.preOrder(tree.root);
        System.out.println("先");

        tree.inOrder(tree.root);
        System.out.println("中");

        tree.postOrder(tree.root);
        System.out.println("后");

        tree.levelOrder(tree.root);
        System.out.println("层");
    }

//https://www.cnblogs.com/CherishFX/p/4617105.html

}
