package com.wen.algorithm.tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BinarySearchTree {
    Node root;
    int size = 0;
    int[] nodeArray;
    public BinarySearchTree(){

    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    //插入节点
    public void insertNode(int data){
        if(root == null){
            root = new Node(data);
            size ++;
            return;
        }
        Node node = root;
        while(node != null){
            if(node.getData() > data){//比当前节点
                if(node.getLeft() == null){
                    node.setLeft(new Node(data));
                    size ++;
                    return;
                }
                node = node.getLeft();
            }else {
                if(node.getRight() == null){
                    node.setRight(new Node(data));
                    size ++;
                    return;
                }
                node = node.getRight();
            }
        }
    }
    //删除节点

    /**
     * 先序遍历，对于任意一个子树，先打印它本身，然后打印它的左节点，最后打印它的右子树
     */
    public void preOrder(Node node){
        if(node == null){
            return ;
        }
        System.out.print(node.getData()+",");
        preOrder(node.getLeft());
        preOrder(node.getRight());

    }

    /**
     * 中序遍历，对于树中任意一个节点，先打印它对左子树，然后打印它本身，最后打印它对右子树
     */
    public void inOrder(Node node){
        if(node == null){
            return ;
        }
        inOrder(node.getLeft());
        System.out.print(node.getData()+",");
        inOrder(node.getRight());
    }

    /**
     * 后序遍历，对任意一个节点，先打印左子树，接着打印它对右子树，最后打印它本身
     */
    public void postOrder(Node node){
        if(node == null){
            return ;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData()+",");
    }
    //利用队列实现层次遍历
    public void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        if(root != null){
            queue.add(root);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.peek();
            System.out.print(node.getData()+",");
            queue.poll();
            if(null != node.getLeft()){
                 queue.add(node.getLeft());
            }
            if(null != node.getRight()){
                queue.add(node.getRight());
            }

        }



    }


    //构建二叉排序树，
    public void buildSearchTree(){
        for(int node : this.nodeArray){
            this.insertNode(node);
        }
    }
    //根据数组构建一般二叉树，
    public void buildTree(){
       List<Node> nodeList  = new ArrayList();
        for(int data : nodeArray){
            nodeList.add(new Node(data));
        }
        for(int i = 0;i<nodeList.size()/2-1;i++){
            nodeList.get(i).setLeft(nodeList.get(2*i+1));
            nodeList.get(i).setRight(nodeList.get(2*i+2));
        }
        //最后一个父节点：因为最后一个父节点可能没有右孩子，所以单独处理
        int lastParentIndex = nodeList.size()/2-1;
        nodeList.get(lastParentIndex).setLeft(nodeList.get(2*lastParentIndex+1));
        //如果为节点数量为单数，则最后一个父节点有右节点。若为双，则无
        if(nodeList.size()%2 == 1){
            nodeList.get(lastParentIndex).setRight(nodeList.get(2*lastParentIndex+2));
        }
        this.root = nodeList.get(0);

    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                ", nodeArray=" + Arrays.toString(nodeArray) +
                '}';
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getNodeArray() {
        return nodeArray;
    }

    public void setNodeArray(int[] nodeArray) {
        this.nodeArray = nodeArray;
    }
}
