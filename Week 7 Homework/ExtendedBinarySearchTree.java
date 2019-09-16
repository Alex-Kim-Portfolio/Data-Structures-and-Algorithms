//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 7 Homework
//Problem 32, 48a, 48b
//Jason Wertz

import ch04.queues.*;
import ch02.stacks.*;
import ch07.trees.*;
import support.BSTNode;  

public class ExtendedBinarySearchTree<T> extends BinarySearchTree<T>
{
   //Constructor
   public ExtendedBinarySearchTree()
   { 
      super();
   }
   
   
   //Methods
   
   //32 and 48a
   public int iterativeHeight()
   //Returns the height of a tree using an iterative solution
   {
      int height = 0;
      
      LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
      
      queue.enqueue(root);
      
      while(true) {
         int nodeCountInLevel = queue.size();
         if(nodeCountInLevel == 0) {
            return height - 1;
         } else {
            height++;
         }
      
         while(nodeCountInLevel > 0) {
            BSTNode<T> newNode = queue.dequeue();
            if(newNode.getLeft() != null) {
               queue.enqueue(newNode.getLeft());
            }
            if(newNode.getRight() != null) {
               queue.enqueue(newNode.getRight());
            }
            nodeCountInLevel--;
         }
      }
   
   }
   
   public int recHeight()
   //Returns the height of a tree using a recursive solution
   {
      return recHeightHelp(root) - 1;
   }
   
   private int recHeightHelp(BSTNode<T> node)
   //Helper method for the recHeight method
   {
      int height = 0;
      int leftHeight = 0;
      int rightHeight = 0;
   
      if(node == null){
         return 0;
      } else {
         leftHeight = recHeightHelp(node.getLeft());
         rightHeight = recHeightHelp(node.getRight());
         
         if(leftHeight > rightHeight){
            height = leftHeight + 1;
         } else {
            height = rightHeight + 1;
         }
      }
      return height;
   }
   
   //Question 48b
   public double fRatio()
   //Returns the fullness ratio of a tree 
   {
      double fullnessRatio = (double)getMinHeight()/(double)recHeight();
      return fullnessRatio;
   }
   
   public int getMinHeight()
   //Returns the minimum height of a tree
   {
      int minNumLevels = 0;
      int numElements = recSizeHelper(root);
      minNumLevels = ((int)Math.floor(logBase2(numElements))) + 1;
      return minNumLevels - 1;
   }
   
   //Duplicating this method so the getMinHeight() method can access it
   private int recSizeHelper(BSTNode<T> node)
   // Returns the number of elements in subtree rooted at node
   {
   if (node == null)    
      return 0;
   else
      return 1 + recSizeHelper(node.getLeft()) + recSizeHelper(node.getRight());
   }

   public static int logBase2(int x)
   //Returns the log base 2 of a number
   {
      return (int)(Math.log(x)/Math.log(2));
   }
}