//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 7 Homework
//Problem 48c
//Jason Wertz

import java.util.*;
import ch04.queues.*;
import ch02.stacks.*;
import ch07.trees.*;
import support.BSTNode; 

public class FullnessExperimentApplication
{
   public static void main(String[] args)
   {
      Random random = new Random();
      
      for(int i = 0; i < 10; i++){
         ExtendedBinarySearchTree<Integer> tree = new ExtendedBinarySearchTree<>();
         
         //Add elements to the tree
         for(int j = 0; j < 1000; j++){      
            tree.add(random.nextInt(3000) + 1);
         }
         
         System.out.println("--------------------------------------------------");
         System.out.println("Tree height: " + tree.recHeight());
         System.out.println("Tree optimal height: " + tree.getMinHeight());
         System.out.println("Tree fullness ratio: " + tree.fRatio());
      } 
   }
}






/*
48d Experiment Report and Discussion

After running the program a number of times, I found that the tree heights for the trees would be anywhere from the mid-teens
to around the mid-20s. None of the tree heights entered the 30 range. As a result, the fullness ratio would range from around
30%-50%, but rarely did I see a fullness ratio above 55%. What's interesting is the disparity/size of range for each of these
measurements. The variation shows that the addition of a number into the tree really impacts the balance/fullness of the tree,
based on when it is added to the tree, and the context it is added into. The fRatio method is also extremely useful for any
user due to the fact that they can use this method to peek into the data structure and see if a search algorithm would be fully
optimized in this tree (see if the tree is close to it's most optimal height, which is the minimum height). This would let the
user know whether or not a tree is off-balance and whether or not they should balance out the tree themselves. 
*/