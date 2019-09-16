//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 4 Homework
//Problem 16
//Jason Wertz

import support.LLNode;

public class recursiveNumEvens
{

   public static void main(String[] args)
   {
   
      //Create nodes of Linked List
      LLNode<Integer> node1 = new LLNode<>(1);
      LLNode<Integer> node2 = new LLNode<>(4);
      LLNode<Integer> node3 = new LLNode<>(6);
      LLNode<Integer> node4 = new LLNode<>(7);
      LLNode<Integer> node5 = new LLNode<>(11);
      LLNode<Integer> node6 = new LLNode<>(18);
      LLNode<Integer> node7 = new LLNode<>(28);
      
      //Set links
      node1.setLink(node2);
      node2.setLink(node3);
      node3.setLink(node4);
      node4.setLink(node5);
      node5.setLink(node6);
      node6.setLink(node7);
      
      //Print result
      System.out.println("The number of even numbers in this list: " + numEvens(node1));
      
   }//End of main
   
   
   public static int numEvens(LLNode<Integer> list)
   //A method that keeps track of/accumulates the number of even numbers in a list.
   //Input(starting node) must be of type LLNode<Integer>.
   {
   
      //Variable to keep track of number of even numbers in the list of n elements
      int evenCount = 0;
      
      //If the node is not empty and is even, increase evenCount.
      if(list != null){
      
         if(list.getInfo() % 2 == 0){
            evenCount++;
         }
         
         //Recursively call the numEvens method for the n-1 elements, and add tally up the even numbers for each call to the method
         evenCount += numEvens(list.getLink());
         
      }
      
      return evenCount;
      
   }//End of numEvens
   
}//End of Program