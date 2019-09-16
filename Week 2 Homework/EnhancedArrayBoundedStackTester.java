//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 2 Homework
//Problem 28 Tester
//Jason Wertz

import ch02.stacks.*;

public class EnhancedArrayBoundedStackTester
{
   public static void main(String[] args)
   {
      EnhancedArrayBoundedStack<Integer> stack = new EnhancedArrayBoundedStack<>(10);
      
      stack.newPush(100);
      stack.newPush(254);
      stack.newPush(637);
      stack.newPush(21283);
      stack.newPop();
      stack.newPush(62);
      stack.newPush(3293);
      stack.newPush(12);
      stack.newPop();
      stack.newPush(1237);
      stack.newPush(1);
      stack.newPush(74);
      stack.newPush(2398);
      stack.newPop();
      
      //Test toString() method
      System.out.println(stack.toString());
      
      //Test size() method
      System.out.println("Number of items on stack: " + stack.size());
      
      //Test popsome() method
      stack.popsome(6); 
      
      System.out.println("Number of items on stack after popsome function: " + stack.size());
      
      //Test swapStart() method
      System.out.println(stack.swapStart());
      
      //Test poptop() method
      System.out.println(stack.poptop());
      
   }
}