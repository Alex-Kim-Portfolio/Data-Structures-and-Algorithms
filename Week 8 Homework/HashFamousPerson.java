//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 8 Homework
//Problem 24 FamousPerson Class with hashCode method
//Jason Wertz

import java.util.Comparator;

public class HashFamousPerson implements Comparable<HashFamousPerson>
{
  protected String firstName, lastName, fact;
  protected int yearOfBirth;    

  public HashFamousPerson(String first, String last, int yob, String f)
  {
    firstName = first;  lastName = last; fact = f; yearOfBirth = yob;
  }

  public String getFirstName() {return firstName ;}
  public String getLastName() {return lastName;}
  public String getFact() {return fact;}
  public int getYearOfBirth() {return yearOfBirth;}

  @Override 
  public boolean equals(Object obj)
  // Returns true if 'obj' is a FamousPerson with same first and last 
  // names as this FamousPerson, otherwise returns false.
  {
     if (obj == this)
        return true;
     else 
     if (obj == null || obj.getClass() != this.getClass())
        return false;
     else
     {
        HashFamousPerson fp = (HashFamousPerson) obj; 
        return (this.firstName.equals(fp.firstName) &&
                this.lastName.equals(fp.lastName)); 
     }
  }
  
  public int compareTo(HashFamousPerson other)
  // Precondition: 'other' is not null
  //
  // Compares this FamousPerson with 'other' for order. Returns a 
  // negative integer, zero, or a positive integer as this object 
  // is less than, equal to, or greater than 'other'.
  {
    if (!this.lastName.equals(other.lastName))
      return this.lastName.compareTo(other.lastName);
    else
      return this.firstName.compareTo(other.firstName);
  }

  @Override
  public String toString()
  {
    return (firstName + " " + lastName + "(Born " + yearOfBirth +
            "): " + fact);
  }
  
  public static Comparator<HashFamousPerson> yearOfBirthComparator()
  {
    return new Comparator<HashFamousPerson>()
    {
       public int compare(HashFamousPerson element1, HashFamousPerson element2)
       {
         return (element1.yearOfBirth - element2.yearOfBirth);
       }
    };
  }
  
  @Override
  public int hashCode()
  //Returns a hash code value for this FamousPerson object
  {
     return Math.abs((lastName.hashCode() * 3) + firstName.hashCode());
  }

}
 