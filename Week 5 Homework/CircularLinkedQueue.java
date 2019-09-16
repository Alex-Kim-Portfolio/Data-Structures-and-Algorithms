//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 5 Homework
//Problem 25
//Jason Wertz

import ch04.queues.*;
import support.LLNode;

public class CircularLinkedQueue<T> implements QueueInterface<T>
{
   protected LLNode<T> rear;        //reference to the rear of the circular queue
   protected int numElements = 0;   //number of elements in the circular queue
   
   public CircularLinkedQueue()
   //Constructor
   {
      rear = null;
   }
   
   public void enqueue(T element)
   //Adds element to the rear of the circular queue
   {
      LLNode<T> newNode = new LLNode<T>(element);
      if(rear == null){
         rear = newNode;
         rear.setLink(newNode);
      } else {
         newNode.setLink(rear.getLink());
         rear.setLink(newNode);
         rear = newNode;
      }
      numElements++;
   }
   
   public T dequeue()
   //Throws QueueUnderflowException if the circular queue is empty.
   //Otherwise, removes elements from the front of the circular queue.
   {
      if(isEmpty()){
         throw new QueueUnderflowException("Dequeue attempted on an empty circular linked queue.");
      } else {
         T element;
         element = rear.getLink().getInfo();
         rear.setLink(rear.getLink().getLink());
         if(rear.getLink() == null){
            rear = null;
         }
         numElements--;
         return element;
      }
   }
   
   public boolean isEmpty()
   //Returns true if the circular queue is empty. Otherwise, returns false.
   {
      return(rear.getLink() == null);
   }
   
   public boolean isFull()
   //Returns false - a linked circular queue is never full.
   {
      return false; 
   }
   
   public int size()
   //Returns the number of elements in the circular queue.
   {
      return numElements;
   }
   
}
   