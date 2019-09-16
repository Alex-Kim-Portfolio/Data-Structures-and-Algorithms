//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 2 Homework
//Problem 17c
//Jason Wertz

public class ArrayPair<T> implements PairInterface<T>
{
   protected final int ARRAYSIZE = 2;  //Set default array size
   protected T[] pair;  //Create an array named pair of generic type
   protected T firstOfPair;   //first object in the pair
   protected T secondOfPair;  //second object in the pair
   
   //Constructors 
   public ArrayPair()
   {
      pair = (T[]) new Object[ARRAYSIZE];
   }
   
   public ArrayPair(T firstOfPair, T secondOfPair)
   {
      pair = (T[]) new Object[ARRAYSIZE];
      
      pair[0] = firstOfPair;
      pair[1] = secondOfPair;
   }   
   
   //Accessors
   public T getFirst()
   {
      if(pair[0] == null){
         throw new NoValueException("There is no object. Please create an object before retrieving it.");
      } else {
         return pair[0];
      }
   }
   
   public T getSecond()
   {
      if(pair[1] == null){
         throw new NoValueException("There is no object. Please create an object before retrieving it.");
      } else {
         return pair[1];
      }
   }
   
   //Mutators
   public void setFirst(T firstObj)
   {
      pair[0] = firstObj;
   }
   
   public void setSecond(T secondObj)
   {
      pair[1] = secondObj;
   }
   
}//End of ArrayPair