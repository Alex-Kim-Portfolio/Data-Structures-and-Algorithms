//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 7 Homework
//Problem 49a
//Jason Wertz

import java.util.*;
import ch04.queues.*;
import ch02.stacks.*;
import ch07.trees.*;
import support.BSTNode; 

public class FullnessExperimentApplicationPart2
{
   public static void main(String[] args)
   {
      Random random = new Random();
      
      for(int i = 0; i < 10; i++){
         ExtendedBinarySearchTree<Integer> tree = new ExtendedBinarySearchTree<>();
         
         //Add elements to the tree
         for(int j = 0; j < 1000; j++){
         
            int randomPercent = random.nextInt(100);
            int k = random.nextInt(100);
            
            //The element has a k% chance of being 42, and a (1-k)% chance of being a number 1-3000
            if(randomPercent < k){
               tree.add(42);
            } else {      
               tree.add(random.nextInt(3000) + 1);
            }
         }
         
         System.out.println("--------------------------------------------------");
         System.out.println("Tree height: " + tree.recHeight());
         System.out.println("Tree optimal height: " + tree.getMinHeight());
         System.out.println("Tree fullness ratio: " + tree.fRatio());
      } 
   }
}