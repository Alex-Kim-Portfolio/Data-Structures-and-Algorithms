//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 8 Homework
//Problem 10d
//Jason Wertz

import java.util.*;
import ch07.trees.*;
import ch08.maps.*;
import support.BSTNode;

//Change MapEntry to public in MapEntry file
//MapEntry edited class is found below the program as a commented block. Use this code for MapEntry class.

public class BSTMap<K, V> implements MapInterface<K, V>
{
   protected BinarySearchTree<MapEntry<K, V>> map;
   
   //Constructor
   public BSTMap()
   {
      map = new BinarySearchTree<MapEntry<K, V>>();
   }

   public V put(K k, V v)
   // If an entry in this map with key k already exists then the value 
   // associated with that entry is replaced by value v and the original
   // value is returned; otherwise, adds the (k, v) pair to the map and
   // returns null.
   {
      if(k == null){
         throw new IllegalArgumentException("Maps do not allow null keys.");
      }
      
      MapEntry<K, V> entry = new MapEntry<K, V>(k, v);
      
      MapEntry<K, V> temp;
      Iterator<MapEntry<K, V>> iter = map.getIterator(BSTInterface.Traversal.Inorder);
      while(iter.hasNext())
      {
         temp = iter.next();
         if(temp.getKey().equals(k)){
            map.remove(temp);
            map.add(entry);
            return temp.getValue();
         }
      }
      
      // No entry is associated with k.
      map.add(entry);
      return null;
   }
   
   public V get(K k)
   // If an entry in this map with a key k exists then the value associated 
   // with that entry is returned; otherwise null is returned.
   {
      if (k == null){
         throw new IllegalArgumentException("Maps do not allow null keys.");
      }
      
      MapEntry<K, V> temp;
      Iterator<MapEntry<K, V>> iter = map.getIterator(BSTInterface.Traversal.Inorder);
      while(iter.hasNext())
      {
         temp = iter.next();
         if(temp.getKey().equals(k)){
            return temp.getValue();
         }
      }
      
      // k is not found
      return null;
   }
   
   public V remove(K k)
   // If an entry in this map with key k exists then the entry is removed
   // from the map and the value associated with that entry is returned;
   // otherwise null is returned.
   {
      if (k == null){
         throw new IllegalArgumentException("Maps do not allow null keys.");
      }

      MapEntry<K,V> temp;
      Iterator<MapEntry<K, V>> iter = map.getIterator(BSTInterface.Traversal.Inorder);
      while(iter.hasNext())
      {
         temp = iter.next();
         if (temp.getKey().equals(k)){
            map.remove(temp);
            return temp.getValue();
         }
      }
      
      // k is not found
      return null;
   }
   
   public boolean contains(K k)
   // Returns true if an entry in this map with key k exists;
   // Returns false otherwise.
   {
      if (k == null){
         throw new IllegalArgumentException("Maps do not allow null keys.");
      }
      
      MapEntry<K,V> temp;
      Iterator<MapEntry<K, V>> iter = map.getIterator(BSTInterface.Traversal.Inorder);
      while(iter.hasNext())
      {
         temp = iter.next();
         if (temp.getKey().equals(k)){
            return true;
         }
      }
      
      // k is not found
      return false;
   }
   
   public boolean isEmpty()
   // Returns true if this map is empty; otherwise, returns false.
   {
      return (map.size() == 0);
   }
  
   public boolean isFull()
   // Returns false; this MapBST is never full.
   {
      return false;
   }
   
   public int size()
   // Returns the number of entries in this map.
   {
      int numEntries = 0;
      
      MapEntry<K,V> temp;
      Iterator<MapEntry<K, V>> iter = map.getIterator(BSTInterface.Traversal.Inorder);
      while(iter.hasNext())
      {
         temp = iter.next();
         numEntries++;
      }
      
      return numEntries;
   }
   
   public Iterator<MapEntry<K, V>> iterator()
   // InOrder is the default, "natural" order.
   {
      return map.getIterator(BSTInterface.Traversal.Inorder);
   }
}






//MapEntry edited class

/*
package ch08.maps;

import java.util.*;   // Comparator

public class MapEntry<K, V> implements Comparable<MapEntry<K, V>>
{
  protected K key;
  protected V value;
  
  public MapEntry(K k, V v)
  {
    key = k; value = v;
  }
  
  public int compareTo(MapEntry<K, V> obj)
  {
   return((Comparable)this.key).compareTo(obj.key);
  }
  
  public K getKey()  {return key;}
  public V getValue(){return value;}
  public void setValue(V v){value = v;}

  @Override
  public String toString()
  // Returns a string representing this MapEntry.
  {
    return "Key  : " + key + "\nValue: " + value;
  }
}
*/