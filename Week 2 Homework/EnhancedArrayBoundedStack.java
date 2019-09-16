//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 2 Homework
//Problem 28
//Jason Wertz

import ch02.stacks.*;

public class EnhancedArrayBoundedStack<T> extends ArrayBoundedStack<T>
{
   //Constructors
   public EnhancedArrayBoundedStack()
   {
      super();
   }
   
   public EnhancedArrayBoundedStack(int maxsize)
   {
      super(maxsize);
   }

   public String toString()
   //Returns a string that represents the current stack
   {  
      String list = "";
      
      for(int i = 0; i <= topIndex; i++){
         list += elements[i].toString() + " ";
      }
      
      return "Elements in stack (from bottom to top): " + list;
   }

   public int size()
   //Returns the number of elements currently on the stack
   {
      return topIndex + 1;
   }
   
   public void popsome(int count)
   //Throws StackUnderflowException if there are less than number of specified elements on the stack,
   //Otherwise, removes the number of specified elements from the stack
   {
      if((topIndex+1) < count){
         throw new StackUnderflowException("Too few items to pop off.");
      } else {
         for(int i = topIndex; i > (topIndex - count); i--){
            elements[i] = null;
         }
         topIndex -= count;
      } 
   }
   
   public boolean swapStart()
   //Returns false if there are less than two elements on the stack,
   //Otherwise, reverses the order of the top two elements on the stack and returns true
   {
      if((topIndex+1) < 2){
         return false;
      } else { 
         T temp = elements[topIndex];
         elements[topIndex] = elements[topIndex-1];
         elements[topIndex-1] = temp;
         return true;
      }  
   }
   
   public T poptop()
   //Throws StackUnderflowException if the stack is empty,
   //Otherwise, it both removes and returns the top element of the stack 
   {
      if(topIndex == -1){
         throw new StackUnderflowException("Poptop attempted on an empty stack.");
      } else {
         elements[topIndex] = null;
         topIndex--;
         if(topIndex == -1){
            throw new StackUnderflowException("Empty stack occurred after poptop was attempted.");
         } else {
            T topOfStack = elements[topIndex];
            return topOfStack;
         } 
      }     
   }
   
   //Creating new push and pop methods in order to mimic push and pop methods of original ArrayBoundedStack class,
   //so it can be used in the driver/tester file
   
   public void newPush(T element)
   //Throws a StackOverflowException if the stack is full,
   //Otherwise, adds an element to the top of the stack
   {
      if(topIndex == (elements.length-1)){
         throw new StackOverflowException("New push attempted on a full stack.");
      } else {
         topIndex++;
         elements[topIndex] = element;
      }
   }
   
   public void newPop()
   //Throws StackUnderflowException if the stack is empty,
   //Otherwise, removes top element from the stack
   {
      if(topIndex == -1){
         throw new StackUnderflowException("New pop attempted on an empty stack.");
      } else {
         elements[topIndex] = null;
         topIndex--;
      }
   }
      
}