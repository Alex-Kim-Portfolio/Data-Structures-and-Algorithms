//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 5 Extra Credit
//Problem 45 Application
//Jason Wertz

public class PrintCharTester
{
   public static void main(String[] args) throws InterruptedException
   {
      Runnable r1 = new PrintChar('A', 21);
      Runnable r2 = new PrintChar('B', 23);
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      
      t1.start();
      //t1.join();
      t2.start();
      //t2.join();
   }
}


/*

Experimentation Report

After experimenting with the following program, I found a couple of interesting
things concerning threads and concurrency. First, after running the program
with just the start methods (for t1 and t2), I received different results than
what I had expected for the many runs/test runs that I performed. There were many
runs where the character 'B' would print out a couple times in between successive
'A' characters, and vice versa. This was due to concurrency and a lack of the .join() 
method. The A's would not finish printing out completely (specified number of times) 
before the B's started to print. Once I added the lines that are currently commented out 
(t1.join() after t1.start() and t2.join() after t2.start()), the results became consistent 
with the expected outcome. The A's would finish printing before the B's. However, 
when both join() methods were put after t2.start(), the inconsistent results returned, 
due to each thread not being able to finish their process before the start of another, 
and due to the join method taking hold after the second thread began (AKA, the join 
methods didn't matter unless they were put directly after their respective threads).

*/
