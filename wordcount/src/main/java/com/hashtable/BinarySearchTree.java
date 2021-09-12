package com.hashtable;

public class BinarySearchTree {
    BstNode<Integer> root;
    public BinarySearchTree(){
        this.root=null;
    }
    public BstNode<Integer> addNodedata(BstNode<Integer> root, Integer data){
        if(root==null){
            BstNode<Integer> temp=new BstNode<>();
            temp.data=data;
            return temp;
        }
        if(root.data.compareTo(data)>0){
            root.left=addNodedata(root.left, data);
            return root;
        }
        else if(root.data.compareTo(data)<0){
            root.right=addNodedata(root.right, data);
            return root;
        }
        else{
            System.out.println("Redundant elements not allowed");
            return root;
        }
    }
    public void addNode(Integer data){
        if(this.root==null){
            root=new BstNode<>();
            root.data=data;
        }
        else{
            root=addNodedata(this.root,data);
        }
    }
    public void inOrder(BstNode<Integer> root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);

    }
    public void preOrder(BstNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(BstNode<Integer> root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data+" ");
    }
    public void search(Integer data,BstNode<Integer> root){
        if(root==null){
            System.out.println("not found");
            return;
        }
        if(root.data==data){
            System.out.println("found");
        }
        else{
            if(root.data>data){
                search(data, root.left);
            }
            else{
                search(data, root.right);
            }
        }
    }
    
}
