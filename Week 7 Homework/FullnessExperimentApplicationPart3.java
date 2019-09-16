//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 7 Homework
//Problem 49b
//Jason Wertz

import java.util.*;
import ch04.queues.*;
import ch02.stacks.*;
import ch07.trees.*;
import support.BSTNode; 

public class FullnessExperimentApplicationPart3
{
   public static void main(String[] args)
   {
      Random random = new Random();
      int k = 10;
      
      for(int x = 0; x < 9; x++){
         int treeHeightSum = 0;
         double fRatioSum = 0.0;
         
         for(int i = 0; i < 10; i++){
            ExtendedBinarySearchTree<Integer> tree = new ExtendedBinarySearchTree<>();
            
            //Add elements to the tree
            for(int j = 0; j < 1000; j++){
            
               int randomPercent = random.nextInt(100);
               
               //The element has a k% chance of being 42, and a (1-k)% chance of being a number 1-3000
               if(randomPercent < k){
                  tree.add(42);
               } else {      
                  tree.add(random.nextInt(3000) + 1);
               }
            }
            
            treeHeightSum += tree.recHeight();
            fRatioSum += tree.fRatio();
         } 
         
         int averageTreeHeight = treeHeightSum/10;
         double averagefRatio = fRatioSum/10.0;
         
         k += 10;
         
         System.out.println("----------------------------------------------------------------");
         System.out.println("Average tree height for this value of k: " + averageTreeHeight);
         System.out.println("Average fullness ratio for this value of k: " + averagefRatio);
      }
   }
}







/*
49c Experiment Report and Discussion

For the program of 49a, the results were pretty consistent. The tree height for each tree in most runs would be somewhere 
within the 400-600 range, and as a result, the fullness ratio was very small. One thing I noticed for each tree, was that
the disparity between the actual tree height and the optimal height was large and so the fullness ratio would be extremely
small compared to the other application program in the assignment. For the program of 49b, the average tree height for each
value of k was very difficult to predict and the results were very spread out. Also, the fullness ratio for this program was
also small, as it was for 49a. In the case where certain values occur more frequently/added more frequently than others, we
could try balancing them out or distributing them more evenely in order to achieve a better minimum height.
*/