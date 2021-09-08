package com.hashtable;

public class Node<K,D> {
    K key;
    D data;
    Node<K,D> chainingLink,nextBlockLink;
    public Node(){
        this.key=null;
        this.data=null;
        this.chainingLink=null;
        this.nextBlockLink=null;
    }    
}
