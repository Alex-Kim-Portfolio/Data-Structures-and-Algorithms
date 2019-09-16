//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 7 Homework
//Problem 32 Tester
//Jason Wertz

import ch04.queues.*;
import ch02.stacks.*;
import ch07.trees.*;
import support.BSTNode; 

public class ExtendedBinarySearchTreeTester
{
   public static void main(String[] args)
   {
      // Multi element tree
      ExtendedBinarySearchTree<String> test = new ExtendedBinarySearchTree<String>();
      boolean result;
      
      //Add elements to the tree      
      result = test.add("alpha");
      result = test.add("beta");
      result = test.add("gamma");
      result = test.add("delta");
      result = test.add("epsilon");
      result = test.add("pi");
      
      //Test and print results of height methods
      System.out.println("Height using iterative height method (root is 0): " + test.iterativeHeight());
      System.out.println("Height using recursive height method (root is 0): " + test.recHeight());
      
      System.out.println("Fullness ratio: " + test.fRatio());
   }
}