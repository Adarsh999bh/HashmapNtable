package com.hashtable;
import java.util.Scanner;
import java.io.*;
/**
 * this is main class wordcountapp which calculats word count in a file 
 *
 */


public class WordcountApp 
{
    public static void main( String[] args ) throws Exception
    {
        //welcome message 
        System.out.println( "Welcome to wordcount program.!" );
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter path to your file");

        //creating buffered reader object 
        BufferedReader br=new BufferedReader(new FileReader(sc.nextLine()));
        sc.close();
        String line=null;
        String content="";
        /**
         * creating a complete string of content by reading line by line and appending it to the content
         * variable
         */
        while((line=br.readLine())!=null){
            content+=line;
        }
        //clasing bufferdreader object
        br.close();

        /**
         * creating array of strings which contains content converted into lowercase
         * and splitted wherever found space
         */
        String[] wordsArray=content.toLowerCase().split(" ");

        //creating hashtable object
        HashTable<String,Integer> newHashTable= new HashTable<>();
        /**
         * iterating through all string elements in the array and trying to put it 
         * to the hash table is the element is already present in the hashtable then hashtable
         * throws ElementAlreadyExistsException exception which is caught here in main and insted of putting 
         * it into the hashtable it updates the data for corresponding key
         */
        for(int i=0;i<wordsArray.length;i++){
            try{
                newHashTable.put(wordsArray[i], 1);   
            }
            catch(ElementAlreadyExistsException eae){
                Integer data=0;
                /**
                 * keynotfound exception handeled on getting node
                 */
                try{
                    data=newHashTable.getData(wordsArray[i]);
                }
                catch(KeyNotFoundException knf){
                    System.out.println(knf.getMessage());
                }
                data+=1;

                /**
                 * keynotfound exception handeled on updating node
                 */
                try {
                    newHashTable.updateData(wordsArray[i], data);
                } catch (KeyNotFoundException knf) {
                    System.out.println(knf.getMessage());
                }
            }
        }

        //displaying contents in the hashtable
        newHashTable.display();
        System.out.println(newHashTable.noOfElementsFilledHashtable);
        
    }
}
