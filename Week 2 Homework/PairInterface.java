//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 2 Homework
//Problem 17a
//Jason Wertz

public interface PairInterface<T>
{
   T getFirst() throws NoValueException;
   //Throws NoValueException if the first position in the array is empty.
   //Returns the first object in the pair of objects.
   
   T getSecond() throws NoValueException;
   //Throws NoValueException if the second position in the array is empty.
   //Returns the second object in the pair of objects.
   
   void setFirst(T firstObj);
   //Sets the first object in the pair of objects.
   
   void setSecond(T secondObj);
   //Sets the second object in the pair of objects.
    
}//End of PairInterface
  