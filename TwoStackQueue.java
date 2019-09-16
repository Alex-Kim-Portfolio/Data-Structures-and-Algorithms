package TwoStackQueue;

import java.util.*;

public class TwoStackQueue<T>
{  
   protected Stack<T> queue = new Stack<T>();
   protected Stack<T> tempStack = new Stack<T>();
   
   public void enqueue(T element)
   {
      while(!queue.empty())
      {
         tempStack.push(queue.pop()); //Fills tempStack with elements preceding new element
      }                               //Note: First element into temp is next to be dequeued
      
      queue.push(element);
      
      while(!tempStack.empty())
      {
         queue.push(tempStack.pop()); //Fills tempStack with elements preceding new element
      }
   }
   
   public T dequeue()
   {
      return queue.pop();
   }
   
   public boolean isEmpty()
   {
      return queue.empty();
   }
}

/*
References:

For general review of java methods:
https://docs.oracle.com/javase/7/docs/api/

Initial Interview Question and Sample Code:
https://www.geeksforgeeks.org/queue-using-stacks/
*/
