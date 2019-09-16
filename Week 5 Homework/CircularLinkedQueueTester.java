//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 5 Homework
//Problem 25 Tester
//Jason Wertz

public class CircularLinkedQueueTester
{
   public static void main(String[] args)
   {
      //Create new queue and declare variables
      CircularLinkedQueue<Integer> queue = new CircularLinkedQueue<>();
      int queueSize = 0;
      boolean queueEmpty;
      
      queue.enqueue(104);
      queue.enqueue(457);
      queue.enqueue(36);
      queue.enqueue(48);
      queue.dequeue();
      queue.enqueue(972);
      queue.enqueue(673);
      queue.dequeue();
      queue.enqueue(572);
      queue.dequeue();
      
      //Test isEmpty method (isFull always returns false)
      queueEmpty = queue.isEmpty();
      System.out.println(queueEmpty);
      
      //Test size method
      queueSize = queue.size();
      System.out.println(queueSize);
      
   }//End of main
}// End of program