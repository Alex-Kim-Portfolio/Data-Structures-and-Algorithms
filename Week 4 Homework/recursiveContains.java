//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 4 Homework
//Problem 17
//Jason Wertz

import support.LLNode;

public class recursiveContains
{

   public static void main(String[] args)
   {
   
      //Create nodes of Linked List
      LLNode<Integer> node1 = new LLNode<>(1);
      LLNode<Integer> node2 = new LLNode<>(7);
      LLNode<Integer> node3 = new LLNode<>(9);
      LLNode<Integer> node4 = new LLNode<>(15);
      LLNode<Integer> node5 = new LLNode<>(20);
      LLNode<Integer> node6 = new LLNode<>(64);
      LLNode<Integer> node7 = new LLNode<>(72);
      
      //Set links
      node1.setLink(node2);
      node2.setLink(node3);
      node3.setLink(node4);
      node4.setLink(node5);
      node5.setLink(node6);
      node6.setLink(node7);
      
      //Print result
      System.out.println(contains(15, node1));
      
   }//End of main
   
   
   public static boolean contains(int target, LLNode<Integer> list)
   //A method that returns whether or not the list has the target number.
   //Input target must be of type integer, and input list (starting node) must be of type LLNode<Integer>.
   {
   
      //Declare variable
      boolean hasTarget = false;
      
      //If the node is not empty and the node's info is the same as target, return true
      if(list != null){
      
         if(list.getInfo() == target){
            hasTarget = true;
         } 
         else {
            //Make a recursive call to the method contains throughout the linked list and save the result in hasTarget 
            hasTarget = contains(target, list.getLink());
         }
         
      }
      
      return hasTarget;
      
   }//End of contains
   
}//End of Program