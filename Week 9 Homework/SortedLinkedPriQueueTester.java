//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 9 Homework
//Problem 8c Tester
//Jason Wertz

import ch09.priorityQueues.*;

public class SortedLinkedPriQueueTester
{
   public static void main(String[] args)
   {
      SortedLinkedPriQueue<Integer> pQueue = new SortedLinkedPriQueue<>();

      pQueue.enqueue(3232);
      pQueue.enqueue(1);
      pQueue.enqueue(19);
      pQueue.enqueue(31);
      pQueue.enqueue(4);
      pQueue.enqueue(95);
      pQueue.enqueue(8);
      pQueue.enqueue(42);

      pQueue.dequeue();
      
      pQueue.dequeue();
      
      pQueue.dequeue();
      
      pQueue.enqueue(13);
      
      System.out.println("Is sorted linked list priority queue full: " + pQueue.isFull());
      
      System.out.println("Is sorted linked list priority queue empty: " + pQueue.isEmpty());
      
      System.out.println("Number of elements in sorted linked list priority queue: " + pQueue.size());
      
      System.out.println(pQueue.toString());
   }
}