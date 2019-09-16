//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 8 Homework
//Problem 24a-e
//Jason Wertz

import java.io.*;
import java.util.*;
import ch08.maps.*;

public class HashFamousPersonApplication
{
   public static void main(String[] args) throws IOException
   {
      double[] array = new double[25];
      int pointer = 0;
      double hashCode;
      double valueToPrint;
      
      //Set up file reading
      FileReader fin = new FileReader("/Users/Alex/Desktop/Summer 2019/CIS 112/bookFiles/input/FamousCS.txt");
      Scanner info = new Scanner(fin);
      info.useDelimiter("[,\\n]");  //Delimiters
    
      Scanner scan = new Scanner(System.in);
      HashFamousPerson person;
      String fname, lname, fact;
      int year;

      //Read the info from the file
      while (info.hasNext())      
      {
         fname = info.next();   
         lname = info.next();
         year = info.nextInt(); 
         fact = info.next();
         person = new HashFamousPerson(fname, lname, year, fact);
         hashCode = person.hashCode();
         array[pointer] = hashCode;
         pointer++;
      }
      
      //Sort the array in increasing order
      sort(array);
      
      //First print of the array in sorted order
      for(int x = 0; x < array.length; x++){
         System.out.println(array[x]);
      }
      
      
      //Mod each value by 1000, sort the array, and print it
      for(int x = 0; x < array.length; x++){
         array[x] = array[x]%1000;
      }
      
      sort(array);
      
      System.out.println("-------------Array after mod 1000-------------");
      for(int x = 0; x < array.length; x++){
         System.out.println(array[x]);
      }
      
      
      //Mod each value by 100, sort the array, and print it
      for(int x = 0; x < array.length; x++){
         array[x] = array[x]%100;
      }
      
      sort(array);
      
      System.out.println("-------------Array after mod 100-------------");
      for(int x = 0; x < array.length; x++){
         System.out.println(array[x]);
      }
      
      
      //Mod each value by 10, sort the array, and print it
      for(int x = 0; x < array.length; x++){
         array[x] = array[x]%10;
      }
      
      sort(array);
      
      System.out.println("-------------Array after mod 10-------------");
      for(int x = 0; x < array.length; x++){
         System.out.println(array[x]);
      }

   }//End of main
   
   public static double[] sort(double[] unsortedArray){
   
      double[] newArray = new double[unsortedArray.length];
      
      //Sort the array in increasing order
      for(int i = 0; i < unsortedArray.length; i++){
         for(int j = i+1; j < unsortedArray.length; j++){
            if(unsortedArray[i] > unsortedArray[j]){
               double temp = unsortedArray[i];
               unsortedArray[i] = unsortedArray[j];
               unsortedArray[j] = temp;
               newArray = unsortedArray;
            }
         }
      }
      
      return newArray;
   }//End of sort
   
}//End of program



/*
Homework Problem 24e Observation

I found that the mod 1000 results were greater than the mod 100 results, and that the mod 100 
results were greater than the mod 10 results. This meant that as the array had the modulus operation 
performed on its hash codes, the hash codes got smaller and smaller and thus represented the indices 
of a smaller and more manageable array (most likely because the smaller and more precise the divisor, 
the smaller remainder). By mod 10, all the hash codes in the array were under 9.0. This may not be 
good when using a hash table, however, as there would be many collisions due to the frequent 
reoccurence of hash values. 
*/