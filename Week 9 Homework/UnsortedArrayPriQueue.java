//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 9 Homework
//Problem 8a
//Jason Wertz

import ch09.priorityQueues.*;
import java.util.Comparator;

public class UnsortedArrayPriQueue<T> implements PriQueueInterface<T>
{
   protected final int DEFCAP = 100;
   protected T[] elements;
   protected int numElements = 0;
   
   protected Comparator<T> comp; 
   
   //Constructors
   
   public UnsortedArrayPriQueue()
   //Precondition: T implements Comparable
   {
      elements = (T[]) new Object[DEFCAP];
      comp = new Comparator<T>()
      {
         public int compare(T element1, T element2)
         {
            return((Comparable)element1).compareTo(element2);
         }
      };
   }
   
   public UnsortedArrayPriQueue(int maxSize)
   {
      elements = (T[]) new Object[maxSize];
      comp = new Comparator<T>()
      {
         public int compare(T element1, T element2)
         {
            return((Comparable)element1).compareTo(element2);
         }
      };
   }
   
   public UnsortedArrayPriQueue(Comparator<T> comp)
   {
      elements = (T[]) new Object[DEFCAP];
      this.comp = comp;
   }
   
   //Methods
   
   public void enqueue(T element)
   // Throws PriQOverflowException if this priority queue is full;
   // otherwise, adds element to this priority queue.
   {
      if(numElements == elements.length){
         throw new PriQOverflowException("Enqueue attempted on a full priority queue.");   //Change access modifier to public for exception files
      }
      
      int index = numElements;
      elements[index] = element;
      
      numElements++;
   }
   
   public T dequeue()
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
   {
      int index = 0;
      
      if(!isEmpty()){
         for(int i = 1; i < numElements; i++){
            if(comp.compare(elements[i], elements[index]) > 0){
               index = i;
            }
         }
         T result = elements[index];
         elements[index] = elements[numElements - 1];
         elements[numElements - 1] = null;
         numElements--;
         return result;
      } else {
         throw new PriQUnderflowException("Dequeue attempted on an empty priority queue.");   //Change access modifier to public for exception files
      }
   
   } 
   
   public boolean isEmpty()
   // Returns true if this priority queue is empty; otherwise, returns false.
   {
      return(numElements == 0);
   }

   public boolean isFull()
   // Returns true if this priority queue is full; otherwise, returns false.
   {
      return(numElements == elements.length);
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
      String result = "";
      
      for(int i = 0; i < numElements; i++){
         result += elements[i] + " ";
      }
      
      return result;
   }
}