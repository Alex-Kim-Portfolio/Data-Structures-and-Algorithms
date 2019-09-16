//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 5 Extra Credit
//Problem 45 Class
//Jason Wertz

public class PrintChar implements Runnable
{
   private char character;
   private int numOfTimes;
   
   public PrintChar(char character, int numOfTimes)
   {
      this.character = character;
      this.numOfTimes = numOfTimes;
   }
   
   public void run()
   {
      for(int i = 0; i < numOfTimes; i++){
         System.out.println(character);
      }
   }
}