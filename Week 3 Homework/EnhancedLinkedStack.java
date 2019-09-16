//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 3 Homework
//Problem 47
//Jason Wertz

import ch02.stacks.*;
import support.LLNode;

public class EnhancedLinkedStack<T> extends LinkedStack<T>
{
   //Constructor
   public EnhancedLinkedStack(){
      super();
   }
   
   
   public String toString()
   //Returns a String that represents the current stack
   {
      String list = "";
      LLNode<T> currNode = top;
      while(currNode != null){
         list += currNode.getInfo().toString() + " ";
         currNode = currNode.getLink();
      }
      
      return list;
   }
   
   
   public int size()
   //Returns the number of elements currently on the stack
   {
      int nodeCount = 0;
      LLNode<T> currNode = top;
      while(currNode != null){
         nodeCount++;
         currNode = currNode.getLink();
      }
      
      return nodeCount;
   }
   
   
   public void popSome(int count)
   //Throws StackUnderflowException if there are less than specified number of elements on the stack,
   //Otherwise, removes the specified number of elements from the stack.
   {
      int nodeCount = 0;
      LLNode<T> currNode = top;
      while(currNode != null){
         nodeCount++;
         currNode = currNode.getLink();
      }
      
      if(nodeCount < count){
         throw new StackUnderflowException("Too few items to pop off.");
      } else {
         for(int i = 1; i <= count; i++){
            top = top.getLink();
         }
      }
   }
   
   
   public boolean swapStart()
   //Returns false if there are less than two elements on the stack,
   //Otherwise, reverses the order of the top two elements on the stack and returns true
   {
      int nodeCount = 0;
      LLNode<T> currNode = top;
      while(currNode != null){
         nodeCount++;
         currNode = currNode.getLink();
      }
      
      if(nodeCount < 2){
         return false;
      } else {
         currNode = top;
         currNode = top.getLink();
         top.setLink(currNode.getLink());
         currNode.setLink(top);
         top = currNode;
         currNode = null;
         return true;
      }
   }
   
   
   public T poptop()
   //Throws StackUnderflowException if the stack is empty,
   //Otherwise, it both removes and returns the top element of the stack 
   {
      if(top == null){
         throw new StackUnderflowException("Poptop attempted on an empty stack.");
      } else {
         top = top.getLink();
         if(top == null){
            throw new StackUnderflowException("Poptop attempted on an empty stack.");
         } else {
            return top.getInfo();
         }  
      }
   }
   
   
   //Creating new push and pop methods in order to mimic push and pop methods of original LinkedStack class,
   //so it can be used in the driver/tester file
   
   
   public void newPush(T element)
   //Adds an element to the top of the stack
   {
      LLNode<T> newNode = new LLNode<T>(element);
      newNode.setLink(top);
      top = newNode;
   }
   
   public void newPop()
   //Throws StackUnderflowException if the stack is empty,
   //Otherwise, removes top element from the stack
   {
      if (top == null){
         throw new StackUnderflowException("Pop attempted on an empty stack.");
      } else {
         top = top.getLink();
      }
   }
}