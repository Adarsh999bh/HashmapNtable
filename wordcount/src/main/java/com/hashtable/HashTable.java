package com.hashtable;

public class HashTable<K,D> {
    Node<K,D> startingNode,endingNode;
    int sizeOfHashTable,noOfElementsFilledHashtable;
    Node<K,D> head=new Node<>();
    public HashTable(){
        this.noOfElementsFilledHashtable=0;
        this.sizeOfHashTable=11;
        this.startingNode=getLinkedListOfElevenNodes();
    }
    private Node<K,D> getLinkedListOfElevenNodes(){
        Node<K,D> tail=new Node<>();
        head.nextBlockLink=tail;
        for(int i=0;i<this.sizeOfHashTable-2;i++){
            tail.nextBlockLink=new Node<>();
            tail=tail.nextBlockLink;
        }
        return head;
    }
    public int findHashValue(K key){
        String stringKey= String.valueOf(key);
        int sum=0;
        for(int i=0;i<stringKey.length();i++){
            sum+=stringKey.charAt(i);
        }
        return sum % this.sizeOfHashTable;
    }
    public Node<K,D> getNode(int index){
        Node<K,D> temp=this.startingNode;
        while(index>=0){
            temp=temp.nextBlockLink;
            index--;
        }
        return temp;
    }
    public boolean checkIfKeyIsAssignedElseCreatenewNode(Node<K,D> temp,K key,D data){
        while(temp.chainingLink!=null){
            if(temp.key.equals(key)){
                System.out.println("Key is already assigned");
                return true;
            }
            temp=temp.chainingLink;
        }
        temp.chainingLink=new Node<>();
        temp.chainingLink.data=data;
        temp.chainingLink.key=key;
        this.noOfElementsFilledHashtable+=1;
        return false;
    }
    public void put(K key,D data) throws ElementAlreadyExistsException{
        if(key != null && data != null){
            Node<K,D> temp=getNode(findHashValue(key));
            if(temp.key==null){
                temp.key=key;
                temp.data=data;
                this.noOfElementsFilledHashtable+=1;
            }
            else{
                if(checkIfKeyIsAssignedElseCreatenewNode(temp,key,data)){
                    throw new ElementAlreadyExistsException("Element already exists in hash table");
                }
            }
        }
    }
    public D getData(K key){
        Node<K,D> temp=getNode(findHashValue(key));
        return temp.data;
    }
    public void updateData(K key,D data){
        Node<K,D> temp=getNode(findHashValue(key));
        temp.data=data;
    }
    public void display(){
        Node<K,D> temp=this.startingNode;
        while(temp!=null){
            System.out.print(""+temp.key+" : "+temp.data);
            Node<K,D> tempChain=temp.chainingLink;
            while(tempChain!=null){
                System.out.print(" --> "+tempChain.key+" : "+tempChain.data);
                tempChain=tempChain.chainingLink;
            }
            System.out.print(" --> null\n\t|");
            temp=temp.nextBlockLink;
        }
        System.out.println("null");
    }
}
