package com.hashtable;
import java.util.Scanner;
public class BstApp {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Binary Search Tree");
        BinarySearchTree bst=new BinarySearchTree();
        while(true){
            System.out.println("Enter your choice \n1. Add Node\n2. Search Node\n3. Inorder\n4. Preorder\n5. Postorder");
            int choice=Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    System.out.println("Enter the number");
                    bst.addNode(Integer.parseInt(sc.nextLine()));
                    break;
                }
                case 2:{
                    System.out.println("Enter the number you want to search");
                    bst.search(Integer.parseInt(sc.nextLine()), bst.root);
                    break;
                }
                case 3:{
                    bst.inOrder(bst.root);
                    break;
                }
                case 4:{
                    bst.preOrder(bst.root);
                    break;
                }
                case 5:{
                    bst.postOrder(bst.root);
                    break;
                }
                default:{
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}
