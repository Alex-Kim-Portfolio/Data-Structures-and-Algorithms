//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 2 Homework
//Problem 17c Tester
//Jason Wertz

import java.util.*;

public class ArrayPairTester
{
   public static void main (String[] args)
   {
      //Declare thisPair of type PairInterface
      PairInterface<String> thisPair;
      //Instantiate thisPair as instance of ArrayPair and pass in Strings as parameter data types
      thisPair = new ArrayPair<String>("Desk", "Lamp");
      
      //Set first object in pair and print 
      thisPair.setFirst("Pencil Holder");
      
      System.out.println(thisPair.getFirst());
      
      //Set first object again
      thisPair.setFirst("Chair");
      
      //Print second object in pair and then set to different String
      System.out.println(thisPair.getSecond());
      
      thisPair.setSecond("Monitor");
      
      //Print both the first and second object in the pair
      System.out.println(thisPair.getFirst() + " and " + thisPair.getSecond());
      
   }//End of main
}//End of program