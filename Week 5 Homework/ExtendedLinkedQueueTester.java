//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 5 Homework
//Problem 22 Tester
//Jason Wertz

public class ExtendedLinkedQueueTester
{
   public static void main(String[] args)
   {
   
      //Create new queue
      ExtendedLinkedQueue<Integer> queue = new ExtendedLinkedQueue<>();
      
      queue.newEnqueue(100);
      queue.newEnqueue(254);
      queue.newDequeue();
      queue.newEnqueue(99);
      queue.newDequeue();
      queue.newEnqueue(23);
      queue.newEnqueue(37);
      queue.newEnqueue(860);
      queue.newEnqueue(86);
      queue.newEnqueue(753);
      
      //Test remove method
      queue.remove(3);
      
      //Test swapStart method
      queue.swapStart();
      
      //Test swapEnds method
      queue.swapEnds();
      
      //Test toString method
      System.out.println(queue);
      
   }//End of main
}//End of program