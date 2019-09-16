//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 4 Homework
//Problem 2
//Jason Wertz

import java.util.*;

public class recursiveMath
{

   public static void main(String[] args)
   {
      //Declare variables and create Scanner to read keyboard input from user.
      int n;
      
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Please enter an integer: ");
      
      //Catch any input that is not valid and throw exception.
      if(keyboard.hasNextInt()){
         n = keyboard.nextInt();
      } else {
         throw new InputMismatchException("Not a valid input.");
      }
      
      //Pass the integer to the methods and print results.   
      System.out.println("Sum of 1 + 2 + 3 + ... + n = " + sum(n));
         
      System.out.println("2^" + n + " = " + biPower(n));
         
      System.out.println("5*" + n + " = " + timesFive(n));
   }//End of main
   
   
   
   public static int sum(int n)
   //This method returns the result of adding 1 + 2 + 3 + ... + n.
   //n must be a non-negative integer.
   {
      if(n == 1){
         return 1;
      } else {
         return n + sum(n-1);
      }
   }//End of sum
   
   
   
   public static int biPower(int n)
   //This method returns the result of 2^n.
   //n must be a non-negative integer.
   {
      if(n == 1){
         return 2;
      } else {
         return 2 * biPower(n-1);
      }
   }//End of biPower
   
   
   
   public static int timesFive(int n)
   //This method returns the result of 5*n.
   //n must be a non-negative integer.
   {
      if(n == 1){
         return 5;
      } else {
         return 5 + timesFive(n-1);
      }
   }//End of timesFive
   
}//End of program