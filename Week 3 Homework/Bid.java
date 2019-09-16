//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 3 Homework
//Problem 48
//Jason Wertz

import ch02.stacks.*;
import support.LLNode;

public class Bid<T> extends LinkedStack<T>
{
   protected String name;
   protected int bidAmount;
   
   //Constructor
   public Bid(String name, int bidAmount)
   {
      this.name = name;
      this.bidAmount = bidAmount;
   }

   //Mutators and Accessors
   public void setName(String newName)
   {
      name = newName;
   }
   
   public String getName()
   {
      return name;
   }
   
   public void setBidAmount(int bidAmt)
   {
      bidAmount = bidAmt;
   }
   
   public int getBidAmount()
   {
      return bidAmount;
   }
   
   //toString method
   public String toString()
   {
      return name + ", " + bidAmount;
   }
}