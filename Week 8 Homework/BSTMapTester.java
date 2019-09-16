//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 8 Homework
//Problem 10d Tester
//Jason Wertz

import java.util.*;
import ch08.maps.*;

public class BSTMapTester<K, V>
{
   public static void main(String[] args)
   {
      MapInterface<Integer, String> test = new BSTMap<Integer, String>();
      
      System.out.println("BSTMap empty: " + test.isEmpty());
      
      System.out.println("---------------------------------------------");
      
      System.out.println(test.put(1, "One"));
      System.out.println(test.put(2, "Two"));
      System.out.println(test.put(3, "Three"));
      System.out.println(test.put(4, "Four"));
      System.out.println(test.put(5, "Five"));
      System.out.println(test.put(6, "Six"));
      System.out.println(test.put(6, "Six again"));
      System.out.println(test.put(9, "Nine"));
      
      System.out.println("---------------------------------------------");
      
      System.out.println("Current size of BSTMap: " + test.size());
      
      System.out.println("Returning specified item: " + test.get(4));
      
      System.out.println("Removing specified item: " + test.remove(4));
      System.out.println("Removing specified item: " + test.remove(3));
      
      System.out.println("Size of BSTMap after removal(s): " + test.size());
      
      System.out.println("Does BSTMap contain specified item: " + test.contains(4));
      System.out.println("Does BSTMap contain specified item: " + test.contains(9));
      
      System.out.println("BSTMap full: " + test.isFull());
      
      System.out.println("BSTMap empty: " + test.isEmpty());
   }
} 