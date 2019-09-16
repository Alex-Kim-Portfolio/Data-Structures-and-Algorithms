package TwoStackQueue;

import java.util.*;

public class final_driver {
   public static void main(String[] args) {
   
      //declarations
      TwoStackQueue<Integer> queue = new TwoStackQueue();
      int t, q;
      Scanner input = new Scanner(System.in);
      
      //set number of test cases
      System.out.println("Enter the number of test cases:");
      t = input.nextInt();
      
      ////test case loop
      for (int i = 0; i < t; i++) {
   
         //set number of queries
         System.out.println("Enter the number of queries:");
         q = input.nextInt();
         
         input.nextLine(); //Allows nextLine() to work after nextInt()
         
         //get query
         System.out.println("Enter the query:"); 
         Scanner query = new Scanner(input.nextLine()); 
         
         ////parse query
         for (int j = 0; j < q; j++) {
            int n = query.nextInt();             
            
            if (n == 1) {
               queue.enqueue(query.nextInt());
            } else if (n == 2) {
               if (queue.isEmpty()) {
                  System.out.print(-1+" ");
               } else {
                  System.out.print(queue.dequeue()+" ");
               }
            }
         }
         
         //clear the queue and print a line to prepare for next queury
         while (!queue.isEmpty()) {
            queue.dequeue();
         }
         System.out.println();
         
      }
      
   }
}