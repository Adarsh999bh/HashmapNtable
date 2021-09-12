package com.hashtable;

/**
 * class hashtable with all its essential methods to operate like hashtable 
 */
public class HashTable<K,D> {

    /**
     * member data required to operate hash table
     * starting node to keep track of the head node in the hashtable
     * ending node to keep track of  the last node in the hashtable
     * sizeofhashtable gives the current allocated size of the hashtable
     * noofelementsFilledHashTable has the currrent number of elements that are being entered to the hashtable
     * 
    */
    Node<K,D> startingNode,endingNode;
    int sizeOfHashTable,noOfElementsFilledHashtable;
    Node<K,D> head=new Node<>();

    //constructor
    public HashTable(){
        this.noOfElementsFilledHashtable=0;
        this.sizeOfHashTable=11;
        this.startingNode=getLinkedListOfElevenNodes();
    }

    /**
     * method getelinkedlistofelevenNodes creates a linked list of eleven nodes 
     * which is the default size of hash table
     * @return Node<K,D>
     */
    private Node<K,D> getLinkedListOfElevenNodes(){
        Node<K,D> tail=new Node<>();
        head.nextBlockLink=tail;
        for(int i=0;i<this.sizeOfHashTable-2;i++){
            tail.nextBlockLink=new Node<>();
            tail=tail.nextBlockLink;
        }
        return head;
    }

    /**
     * method findHashValue takes key as param input and converts 
     * it into string and applies hash function to it and returns hashvalue mod sizeof hashtable
     * @param key
     * @return int
     */
    public int findHashValue(K key){
        String stringKey= String.valueOf(key);
        int sum=0;
        for(int i=0;i<stringKey.length();i++){
            sum+=stringKey.charAt(i);
        }
        return sum % this.sizeOfHashTable;
    }

    /**
     * method getnode takes index as param input and gets the node which is 
     * index amount far from the starting node
     * @param index
     * @return Node<K,D>
     */
    public Node<K,D> getNode(int index){
        Node<K,D> temp=this.startingNode;
        while(index>=0){
            temp=temp.nextBlockLink;
            index--;
        }
        return temp;
    }

    /**
     * method checkIfKeyIsAssignedElseCreatenewNode takes three params mentioned below 
     * and checks if the key is already assigned if assigned returns true else creates a new node
     * which creates chain for the current node if there is collision in hasah value
     * @param temp
     * @param key
     * @param data
     * @return boolean
     */
    public boolean checkIfKeyIsAssignedElseCreatenewNode(Node<K,D> temp,K key,D data){
        Node<K,D> rev=new Node<>();;
        while(temp!=null){
            if(temp.key.equals(key)){
                System.out.println("Key is already assigned");
                return true;
            }
            rev=temp;
            temp=temp.chainingLink;
        }
        rev.chainingLink=new Node<>();
        rev.chainingLink.data=data;
        rev.chainingLink.key=key;
        this.noOfElementsFilledHashtable+=1;
        return false;
    }

    /**
     * method put tries to put key and data to the hassh table if element already exists
     *  then it throws exception
     * @param key
     * @param data
     * @throws ElementAlreadyExistsException
     */
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

    /**
     * method gtData takes key as input and takes its hashvalue and then 
     * it gets that perticular node and returns the value associated with that key
     * @param key
     * @return D
     */
    public D getData(K key) throws KeyNotFoundException{
        Node<K,D> temp=getNode(findHashValue(key));
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.data;
            }
            temp=temp.chainingLink;
        }
        throw new KeyNotFoundException("Key not present in the hashTable");
    }

    /**
     * method updatedata updates the data on the node for the corresponding key value
     * if key not found it throws exception
     * @param key
     * @param data
     * @throws KeyNotFoundException
     */
    public void updateData(K key,D data)throws KeyNotFoundException{
        Node<K,D> temp=getNode(findHashValue(key));
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.data=data;
                return;
            }
            temp=temp.chainingLink;
        }
        throw new KeyNotFoundException("Key not present in the hashTable")
    }

    /**
     * method display to print elements in the hashtable to console
     */
    public void display(){
        Node<K,D> temp=this.startingNode;
        while(temp!=null){
            System.out.print(""+temp.key+" : "+temp.data);
            Node<K,D> tempChain=temp.chainingLink;
            while(tempChain!=null){
                System.out.print(" --> "+tempChain.key+" : "+tempChain.data);
                tempChain=tempChain.chainingLink;
            }
            System.out.println(" --> null\n |");
            temp=temp.nextBlockLink;
        }
        System.out.println("null");
    }
}
