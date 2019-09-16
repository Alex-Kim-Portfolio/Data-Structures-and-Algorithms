//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 4 Homework Extra Credit
//Problem 18
//Jason Wertz

import support.LLNode;

public class recursiveRemove
{

   public static void main(String[] args)
   {
   
      //Create nodes of Linked List
      LLNode<Integer> node1 = new LLNode<>(9);
      LLNode<Integer> node2 = new LLNode<>(16);
      LLNode<Integer> node3 = new LLNode<>(23);
      LLNode<Integer> node4 = new LLNode<>(7);
      LLNode<Integer> node5 = new LLNode<>(16);
      LLNode<Integer> node6 = new LLNode<>(34);
      LLNode<Integer> node7 = new LLNode<>(92);

      
      //Set links
      node1.setLink(node2);
      node2.setLink(node3);
      node3.setLink(node4);
      node4.setLink(node5);
      node5.setLink(node6);
      node6.setLink(node7);

      //Create a variable to keep track of current node in new linked list with removed target integer
      LLNode<Integer> currNode = remove(16, node1);
      
      //Print the new list with removed target integer
      while(currNode != null){
         System.out.println(currNode.getInfo());
         currNode = currNode.getLink();
      }
      
   }//End of main
   
   
   public static LLNode<Integer> remove(int target, LLNode<Integer> list)
   //A method that removes the target integer from the list and returns the new and edited list.
   //Input target must be of type integer, and input list (starting node) must be of type LLNode<Integer>.
   {
   
      //Check to see if the list is empty
	   if(list != null) {
      
         //If the current node's info is equivalent to the target
         if(list.getInfo() == target){
            //Let temp be the next node in the list (skip over the current node, which has the target variable)
            LLNode<Integer> temp = list.getLink();
            //Recursively call the method and start the method at the next node in the list (helps skip over the node with target number)
            return remove(target, temp);
            
         //If the current node's info is not equivalent to the target
         } else {
            //Create a new instance of class LLNode<Integer> and make the first node the value of current node (which doesn't have target integer)
            LLNode<Integer> newList = new LLNode<>(list.getInfo());
            //Recursively call the method starting at the next node, and when the base case is reached, link all the nodes together.
            //This creates a new linked list that only has the nodes that do not contain the target integer.
            newList.setLink(remove(target, list.getLink()));
            //Return the new linked list
            return newList;
         }
         
      }
     
      //Return null if the list is empty
      return null;
      
   }//End of remove
   
}//End of Program