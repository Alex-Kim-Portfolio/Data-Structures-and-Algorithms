//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 3 Homework
//Problem 48
//Jason Wertz

import ch02.stacks.*;
import support.LLNode;
import java.util.*;

public class Auction
{
   public static void main(String[] args)
   {
      int currMaxBid = 0;
      int highBid = 0;
      String highBidder = "";
      
      //Create the stack
      LinkedStack<Bid> stack = new LinkedStack<>();
      
      //Enter do-while loop as long as user would like to enter new bids.
      do{
         //Create Scanner and ask the user for input.
         Scanner keyboard = new Scanner(System.in);
         
         System.out.println("Please enter the name of the bidder: ");
         String name = keyboard.next();
    
         System.out.println("Please enter the user's bid amount: ");
         int bidAmount = keyboard.nextInt();
            
         //Create new bid object using user input.
         Bid newBid = new Bid(name, bidAmount);
            
         //Push the new bid onto the stack.
         stack.push(newBid);
            
         //New high bidder condition.
         if(newBid.getBidAmount() > currMaxBid) {
            highBid = currMaxBid + 1;
            currMaxBid = newBid.getBidAmount();
            stack.top().setBidAmount(highBid);
         //High bid increase condition.
         } else if((newBid.getBidAmount() < currMaxBid) && (newBid.getBidAmount() > highBid)) {
            highBid = newBid.getBidAmount();
            stack.pop();
            Bid nextNewBid = new Bid(stack.top().getName(), highBid);
            stack.push(nextNewBid);
         //No change.
         } else {
            stack.pop();
         }
         
            
         //Prompt the user for another bid. Catch any illegal input exceptions.
         System.out.println("Would you like to enter another bid? [y/n]");
         
         String answer = keyboard.next();
            
         if(answer.equals("n")){
            break;
         } else if(answer.equals("y")){
            continue;
         } else if(!answer.equals("y") || !answer.equals("n")){
            throw new IllegalArgumentException("Illegal input. Input must be the specified [y/n].");
         }
         
      } while(true);

          
      //Print out the final stack of results.
      System.out.println("Here is the bid history from high bid to low bid");
      while(!stack.isEmpty()){
         System.out.println(stack.top());
         stack.pop();
      }
   }
}
      