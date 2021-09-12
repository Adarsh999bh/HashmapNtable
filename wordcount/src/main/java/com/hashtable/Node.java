package com.hashtable;

/**
 * this is node class with all the members required to create hashTable
 * where chaining link refers to chains that will be creted during collision
 * in hash values.
 * and next block refers to the next block of node in hash table
 */

public class Node<K,D> {
    K key;
    D data;
    Node<K,D> chainingLink,nextBlockLink;
    //constructor initilizing member data
    public Node(){
        this.key=null;
        this.data=null;
        this.chainingLink=null;
        this.nextBlockLink=null;
    }    
}
