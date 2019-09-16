//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 1 Homework
//Jason Wertz

import java.util.*;

public class ArraySkills {


   public static void main(String[] args) throws Exception {
   
      // ***********************
      // For each item below you must code the solution. You may not use any of the
      //  methods found in the Arrays class or the Collections classes
      //
   
      String[] myData;
   
   
      // 1. Instantiate the given array to hold 10 Strings.
      
      myData = new String[10];
      
      
      
      // 2. Add your name to the Array at index 0 and a friend's name to the Array at index 4
      
      myData[0] = "Alex"; myData[4] = "Zack";
            
            
            
      // 3. Move your friend's name to index 0 in the array and "delete" their name from index 4
      
      myData[0] = myData[4];
      
      myData[4] = null;
      
      
      
      // 4. Fill up all of the remaining indeces in the array with more names
      
      myData[1] = "Amanda";
      myData[2] = "Paul";
      myData[3] = "Tyler";
      myData[4] = "Jalen";
      myData[5] = "Angela";
      myData[6] = "Sue";
      myData[7] = "John";
      myData[8] = "Joseph";
      myData[9] = "Chris";
      
      
      
      // 5. Swap the values at index 5 and index 1
      
      String temp1 = myData[1];
      myData[1] = myData[5];
      myData[5] = temp1;
      
      
      
      // 6. Print the array from beginning to end.
      
      for(String name : myData){
      
         System.out.println(name);
         
      }
      
      
      
      // 7. Shuffle the array of strings
      
      for(int i = 0; i < myData.length; i++){
      
         int randomIndex = (int)(Math.random() * myData.length);
         
         String temp2 = myData[i];
         myData[i] = myData[randomIndex];
         myData[randomIndex] = temp2;
         
      }
      
      
      
      // 8. Find and print the longest and shortest Strings in the array
      
      for(int i = 1; i < myData.length; i++){
      
         int elementLength = myData[i].length();
         
         for(i = i; i > 0; i--){
         
            if(elementLength < myData[i-1].length()){
               String temp3 = myData[i-1];
               myData[i-1] = myData[i];
               myData[i] = temp3;      
            } else {
               break;
            }
            
         }
         
      }
      
      String shortest = myData[0];
      String longest = myData[9];
      
      System.out.println("Shortest name: " + shortest);
      System.out.println("Longest name: " + longest);
      
      
      
      // 9. Add up the total number of characters in all of the strings in the array and print the answer
      
      int totalCharacters = 0;
      
      for(int i = 0; i < myData.length; i++){
      
         int elementLength = myData[i].length();
         
         totalCharacters += elementLength;
      }
      
      System.out.println("Total number of characters: " + totalCharacters);
      
      
   
      // 10. Prompt the user for a String and then perform a linear search of the array
      //  to see if that string is or is not in the array. Print if it is or is not found.
      
      Scanner userInput = new Scanner(System.in);
      
      System.out.println("Please enter a name to search within the array: ");
      
      String name = userInput.next();
      boolean nameExists = false;
      
      
      for(int i = 0; i < myData.length; i++){
         if(name.equals(myData[i])){
            nameExists = true;
            break;
         } else {
            nameExists = false;
         }
      }
      
      if(nameExists){
         System.out.println("The entered name exists within the array!");
      } else {
         System.out.println("The entered name does not exist within the array.");
      }



      // 11. Remove the item at index 4 of the array by shifting everything after it one spot to the left.
      // This means your array should have one empty index at the end after the shift (delete the duplicate item at the end).
      
      for(int i = 4; i < myData.length; i++){
         myData[i-1] = myData[i];
      }
      
      myData[9] = null;
      
      
          
      // 12. Create a new array that is twice as big as the current array and copy all of the items to the new array.
      // When complete, swap references so our old array gets garbage collected and the new array is pointed to by your array variable myData.
      
      String[] myNewData = new String[(myData.length * 2)];
      
      for(int i = 0; i < myData.length; i++){
         myNewData[i] = myData[i];
      }
      
      myData = myNewData;
      
      
      
      // 13. Prompt the user to enter 2 numbers within the range of the array's length. If the first is larger than the second print backwards from that index to the first.
      // If the second is larger than the first, print forward in the array from the first index to the second.
      
      System.out.println("Please enter two integers between 0 and 8. Press enter after entering each integer.");
      
      int userInt1 = userInput.nextInt();
      int userInt2 = userInput.nextInt();
      
      if(userInt1 < 0 || userInt1 > 9 || userInt2 < 0 || userInt2 > 9){
         throw new Exception("Values entered must be integers between 0 and 8.");
      } else {  
         if(userInt1 > userInt2){
            for(int i = userInt1; i >= userInt2; i--){
               System.out.println(myData[i]);
            }
         } else {
            for(int i = userInt1; i <= userInt2; i++){
               System.out.println(myData[i]);
            }
         }
      }
      
      
      
   }//End of main

}//End of program