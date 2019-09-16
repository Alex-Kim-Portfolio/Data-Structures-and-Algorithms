package TwoStackQueue;

import java.util.*;

public class PriTwoStackQueue<T> extends TwoStackQueue<T> //Sorted in descending order
{                                                                //enqueue implements comparison
   protected Comparator<T> comp;
   
   public PriTwoStackQueue()
   {
      comp = new Comparator<T>()
      {
         public int compare(T element1, T element2)
         {
            return ((Comparable)element1).compareTo(element2);
         }
      };
   }

   public void enqueue(T element)
   {
      while(!queue.empty())
      {
         tempStack.push(queue.pop()); //Fills tempStack with all current elements
      }
      
      while(true)
      {
         if(tempStack.empty() || comp.compare(element, tempStack.peek()) > 0)//If element to be added is larger than the peek element of the temporary stack, then push element
         {                                                                   //tempStack.empty() handles both corner cases of first element to be enqueued
            queue.push(element);                                             //and if element to be enqueued is the new maximum (last element)
            break;
         }else
          {
            queue.push(tempStack.pop()); 
          }
      }
      
      while(!tempStack.empty())
      {
         queue.push(tempStack.pop()); //Fills queue with remaining elements in tempStack if any are present
      }
   }
}