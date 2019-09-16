/*
   CIS 112 Final Project: Stephanie St. John and Sarah Wagner
   Flood Fill Algorithm
*/
public class FloodFillAlgorithm { 

   // Dimensions of paint screen, need to be global
   static int row = 6; //number of rows
   static int col = 4; //number of columns

   public static void main(String[] args) { 
   
      //declares and instantiates a multidimensional array for our test matrix
      int screen[][] = {{1, 1, 1, 1}, 
               		   {1, 1, 0, 1}, 
               		   {1, 0, 1, 0}, 
               		   {1, 0, 1, 0}, 
               		   {1, 1, 0, 1}, 
               		   {1, 1, 1, 2}, 
         		
      }; 
      
      System.out.println("Original matrix: "); 
      for (int i = 0; i < row; i++) { 
         for (int j = 0; j < col; j++) 
            System.out.print(screen[i][j] + " "); 
         System.out.println(); 
      } 
   
      //represents the spread and change in fill "value"
      //Start at index 0,0 and replace with n value
      //starting position sets target value
      int x = 0, y = 0, newVal = 3; 
      floodFill(screen, x, y, newVal); 
   
      //Print the new screen
      System.out.println("\nUpdated screen after call to floodFill: "); 
      for (int i = 0; i < row; i++) { 
         for (int j = 0; j < col; j++) 
            System.out.print(screen[i][j] + " "); 
         System.out.println(); 
      } 
   } // end of main method

   /*recursive method that replaces the previous value as well as it's surrounding values that are equal to value set
   with the new value starting at the set index */
   //takes start position, target value, and replacement value
   public static void ffRecReplace(int screen[][], int x, int y, int prevVal, int newVal) { 
   
      // Base case checks boundaries of the matrix and value of index
      if (x < 0 || x >= row || y < 0 || y >= col)
         return; 
      if (screen[x][y] != prevVal) 
         return; 
   
      // replace the value at (x, y) 
      screen[x][y] = newVal; 
   
      // call recursively to replace original value with new value in each direction from start index (S,W,N,E) 
      ffRecReplace(screen, x+1, y, prevVal, newVal); 
      ffRecReplace(screen, x-1, y, prevVal, newVal); 
      ffRecReplace(screen, x, y+1, prevVal, newVal); 
      ffRecReplace(screen, x, y-1, prevVal, newVal); 
   } // end of ffRecReplace method

   // Finds the previous value on (x, y) and 
   // call ffRecReplace() 
   public static void floodFill(int screen[][], int x, int y, int newVal) { 
      int prevVal = screen[x][y]; 
      ffRecReplace(screen, x, y, prevVal, newVal); 
   } // end of floodFill method
} // end of program