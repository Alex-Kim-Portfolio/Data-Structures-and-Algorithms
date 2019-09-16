//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 9 Homework
//Problem 8b
//Jason Wertz

import java.util.Comparator;
import support.LLNode;
import ch09.priorityQueues.*;

public class UnsortedLinkedPriQueue<T> implements PriQueueInterface<T>
{
   protected LLNode<T> front;
   protected LLNode<T> rear;
   protected int numElements = 0;
   
   protected Comparator<T> comp;
   
   //Constructors
   
   public UnsortedLinkedPriQueue()
   //Precondition: T implements Comparable
   {
      front = null;
      rear = null;
      
      comp = new Comparator<T>()
      {
         public int compare(T element1, T element2)
         {
            return((Comparable)element1).compareTo(element2);
         }
      };
   } 
   
   public UnsortedLinkedPriQueue(Comparator<T> comp)
   {
      front = null;
      rear = null;
      this.comp = comp;
   }

   //Methods
   
   public void enqueue(T element)
   // Adds element to the rear of this priority queue.
   {
      LLNode<T> newNode = new LLNode<T>(element);
    
      if (rear == null){
         front = newNode;
      } else {
         rear.setLink(newNode);
      }
    
      rear = newNode;
      numElements++;
   }

   public T dequeue()
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
   {
      LLNode<T> currNode = front.getLink();
      LLNode<T> prevNode = null;
      LLNode<T> maxNode = front;
      T result;
       
      if(isEmpty()){
         throw new PriQUnderflowException("Dequeue attempted on an empty priority queue.");   //Change access modifier to public for exception files
      } else {
         //Find node with highest priority
         while(currNode != null){
            if(comp.compare(currNode.getInfo(), maxNode.getInfo()) > 0){
               maxNode = currNode;
            }
            currNode = currNode.getLink();
         }
         
         //Reset currNode
         currNode = front;
         
         //Check to see if first node is the node to be removed
         if(maxNode == front){
            result = front.getInfo();
            front = front.getLink();
            numElements--;
         } else {    
            //Find node before/preceding the maxNode (node with highest priority)
            while(currNode != null){
               if(currNode.getLink() == maxNode){
                  prevNode = currNode;
                  break;
               } else {
                  currNode = currNode.getLink();
               }
            }
         
            //Reset rear if the node to be removed is the last node
            if(maxNode.getLink() == null){
               rear = prevNode;
            }
            
            prevNode.setLink(maxNode.getLink());
             
            numElements--;
           
            result = maxNode.getInfo();
         }
         
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