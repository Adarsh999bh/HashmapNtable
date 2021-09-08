package com.hashtable;

public class HashTable<K,D> {
    Node<K,D> startingNode,endingNode;
    int sizeOfHashTable,noOfElementsFilledHashtable;
    public HashTable(){
        this.noOfElementsFilledHashtable=0;
        this.sizeOfHashTable=11;
        this.startingNode=getLinkedListOfElevenNodes();
    }
    private Node<K,D> getLinkedListOfElevenNodes(){
        Node<K,D> head=new Node<>();
        Node<K,D> tail=new Node<>();
        head.nextBlockLink=tail;
        for(int i=0;i<this.sizeOfHashTable-2;i++){
            tail.nextBlockLink=new Node<>();
            tail=tail.nextBlockLink;
        }
        return head;
    }
}
