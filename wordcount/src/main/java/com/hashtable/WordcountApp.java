package com.hashtable;

import java.io.*;
/**
 * Hello world!
 *
 */
import java.util.Scanner;

public class WordcountApp 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Welcome to wordcount program.!" );
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter path to your file");
        sc.close();
        BufferedReader br=new BufferedReader(new FileReader(sc.nextLine()));
        String line=null;
        String content="";
        while((line=br.readLine())!=null){
            content+=line;
        }
        br.close();
        String[] wordsArray=content.toLowerCase().split(" ");
        HashTable<String,Integer> newHashTable= new HashTable<>();
        for(int i=0;i<wordsArray.length;i++){
            try{
                newHashTable.put(wordsArray[i], 1);   
            }
            catch(ElementAlreadyExistsException eae){
                Integer data=newHashTable.getData(wordsArray[i]);
                data+=1;
                newHashTable.updateData(wordsArray[i], data);
            }
        }

        newHashTable.display();
        
    }
}
