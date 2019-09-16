//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 5 Homework
//Problem 22
//Jason Wertz

import ch04.queues.*;
import support.LLNode;

public class ExtendedLinkedQueue<T> extends LinkedQueue<T>
{

   //Constructor
   public ExtendedLinkedQueue(){
      super();
   }
   
   
   //Methods
   public String toString()
   //Returns a String that represents the current elements in the queue
   {
      String list = "";
      LLNode<T> currNode = front;
      while(currNode != null){
         list += currNode.getInfo().toString() + " ";
         currNode = currNode.getLink();
      }
      
      return list;
   }
   
   
   public void remove(int count)
   //Throws QueueUnderflowException if there less than the specified number of elements in the queue.
   //Otherwise, removes the specified number of elements from the front of the queue. 
   {
      if(numElements < count){
         throw new QueueUnderflowException("Too few items in queue to perform remove operation.");
      } else {
         for(int i = 0; i < count; i++){
            front = front.getLink();
            numElements--;
         }  
      }
   }
   
   
   public boolean swapStart()
   //Returns false if there are less than two elements in the queue.
   //Otherwise, reverses the first two elements in the queue and returns true. 
   {
      if(numElements < 2){
         return false;
      } else {
         LLNode<T> currNode = front;
         currNode = front.getLink();
         front.setLink(currNode.getLink());
         currNode.setLink(front);
         front = currNode;
         if(numElements == 2){
            rear = front.getLink();  
         }
         currNode = null;
         return true;
      }
   }
   
   
   public boolean swapEnds()
   //Returns false if there are less than two elements in the queue.
   //Otherwise, swaps the first and last elements of the queue and returns true.
   {
      if(numElements < 2){
         return false;
      } else {
         LLNode<T> currNode = front;
         while(currNode.getLink().getLink() != null){
            currNode = currNode.getLink();
         }
         currNode.setLink(front);
         rear.setLink(front.getLink());
         front.setLink(null);
         LLNode<T> temp = front;
         front = rear;
         rear = temp;
         return true;   
      }
   }
   
   
   public void newEnqueue(T element)
   //Adds element to the rear of the queue. Creating this method to use in the tester file.
   {
      LLNode<T> newNode = new LLNode<T>(element);
      if (rear == null) {
         front = newNode;
      } else {
         rear.setLink(newNode);
      }
      rear = newNode;
      numElements++;
   }
   
   
   public T newDequeue()
   //Throws QueueUndeflowException if the queue is empty.
   //Otherwise, removes the first element in the queue and returns it. 
   {
      if(front == null){
         throw new QueueUnderflowException("newDequeue attempted on an empty queue.");
      } else {
         T element;
         element = front.getInfo();
         front = front.getLink();
         if(front == null){
            rear = null;
         }
         numElements--;
         return element;  
      }
   }
   
}//End of ExtendedLinkedQueue