//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 9 Homework
//Problem 8c
//Jason Wertz

import java.util.Comparator;
import support.LLNode;
import ch09.priorityQueues.*;

public class SortedLinkedPriQueue<T> implements PriQueueInterface<T>
{
   protected LLNode<T> front;
   protected int numElements = 0;
   
   protected Comparator<T> comp;
   
   //Constructors
   
   public SortedLinkedPriQueue()
   //Precondition: T implements Comparable
   {
      front = null;
      
      comp = new Comparator<T>()
      {
         public int compare(T element1, T element2)
         {
            return((Comparable)element1).compareTo(element2);
         }
      };
   } 
   
   public SortedLinkedPriQueue(Comparator<T> comp)
   {
      front = null;
      this.comp = comp;
   }
   
   //Methods
   
   public void enqueue(T element)
   //Adds elements to this priority queue in decreasing order.
   {
      LLNode<T> newNode = new LLNode<T>(element);
      
      if(isEmpty()){
         front = newNode;
         numElements++;
      } else if(front.getLink() == null){
         if(comp.compare(newNode.getInfo(), front.getInfo()) > 0){
            newNode.setLink(front);
            front = newNode;
            numElements++;
         } else {
            front.setLink(newNode);
            numElements++;
         }
      } else {
         LLNode<T> currNode = front;
         LLNode<T> prevNode = null;
      
         while(currNode != null){
            if(comp.compare(newNode.getInfo(), currNode.getInfo()) > 0){
               if(currNode == front){
                  newNode.setLink(currNode);
                  front = newNode;
                  numElements++;
                  break;
               } else {
                  prevNode.setLink(newNode);
                  newNode.setLink(currNode);
                  numElements++;
                  break;
               }
            } else {
               prevNode = currNode;
               currNode = currNode.getLink(); 
            }    
         }
      } 
   }
   
   public T dequeue()
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
   {
      if(isEmpty()){
         throw new PriQUnderflowException("Dequeue attempted on an empty priority queue.");   //Change access modifier to public for exception files
      } else {
         T result = front.getInfo();
         front = front.getLink();
         numElements--;
         return result;
      }
   }
   
   public boolean isEmpty()
   // Returns true if this priority queue is empty; otherwise, returns false.
   {
      return(front == null);
   }
   
   public boolean isFull()
   // Returns false - a linked priority queue is never full.
   {
      return false; 
   }
   
   public int size()
   // Returns the number of elements in this priority queue.
   {
      return numElements;
   }
   
   @Override
   public String toString()
   // Returns a String that represents the elements in this priority queue.
   {
      LLNode<T> currNode = front;
      String result = "";
      
      while(currNode != null){
         result += currNode.getInfo() + " ";
         currNode = currNode.getLink();
      }
      
      return result;
   }

}