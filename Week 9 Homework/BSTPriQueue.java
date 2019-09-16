//Alexander Kim
//CIS 112 ONLN2 Summer 2019 Week 9 Homework
//Problem 8d
//Jason Wertz

import java.util.*;

import ch09.priorityQueues.*;
import support.BSTNode; 

public class BSTPriQueue<T> implements PriQueueInterface<T>
{
   protected BSTNode<T> root;
   protected Comparator<T> comp;
   protected boolean found;
   
   //Constructors
   
   public BSTPriQueue()
   //Precondition: T implements Comparable
   {
      root = null;
      comp = new Comparator<T>()
      {
         public int compare(T element1, T element2)
         {
            return ((Comparable)element1).compareTo(element2);
         }
      };
   }
   
   public BSTPriQueue(Comparator<T> comp)
   {
      root = null;
      this.comp = comp;
   }
   
   //Methods
   
   public void enqueue(T element)
   // Adds element to this BST priority queue in proper order.
   {
      root = recAdd(element, root);
   }
   
   public T dequeue()
   // Throws PriQUnderflowException if this BST priority queue is empty;
   // otherwise, removes element with highest priority (rightmost node) from this 
   // BST priority queue and returns it.
   {
      if(isEmpty()){
         throw new PriQUnderflowException("Dequeue attempted on an empty BST priority queue.");   //Change access modifier to public for exception files
      } else {
         T max = this.findMax();
         root = recRemove(max, root);
         return max;
      }
   }
   
   public boolean isFull()
   // Returns false; this link-based BST is never full.
   {
      return false;
   }

   public boolean isEmpty()
   // Returns true if this BST is empty; otherwise, returns false.
   {
      return(root == null);
   }
   
   public int size()
   // Returns the number of elements in this BST.
   {
      return recSize(root);
   }
   
   //Private helper methods
   
   private BSTNode<T> recAdd(T element, BSTNode<T> node)
   // Adds element to tree rooted at node; tree retains its BST property.
   {
      if (node == null){
         // Addition place found
         node = new BSTNode<T>(element);
      } else if (comp.compare(element, node.getInfo()) <= 0){
         node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
      } else {
         node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
      }
      return node;
   }
   
   private int recSize(BSTNode<T> node)
   // Returns the number of elements in subtree rooted at node.
   {
      if (node == null){ 
         return 0;
      } else {
         return 1 + recSize(node.getLeft()) + recSize(node.getRight());
      }
   }

   private T findMax()
   // If this BST is empty, returns null;
   // otherwise returns the largest element of the tree.
   {
      if (isEmpty()){
         return null;
      } else {
         BSTNode<T> node = root;
         while (node.getRight() != null)
            node = node.getRight();
         return node.getInfo();
      }
   }
   
   private T getPredecessor(BSTNode<T> subtree)
   // Returns the information held in the rightmost node of subtree
   {
      BSTNode<T> temp = subtree;
      while (temp.getRight() != null){ 
         temp = temp.getRight();
      }
      return temp.getInfo();
   }
   
   private BSTNode<T> removeNode(BSTNode<T> node)
   // Removes the information at node from the tree. 
   {
      T data;
      if (node.getLeft() == null){
         return node.getRight();
      } else if (node.getRight() == null) {
         return node.getLeft();
      } else {
         data = getPredecessor(node.getLeft());
         node.setInfo(data);
         node.setLeft(recRemove(data, node.getLeft()));  
         return node;
      }
   }
  
   private BSTNode<T> recRemove(T target, BSTNode<T> node)
   // Removes element with info i from tree rooted at node such that
   // comp.compare(target, i) == 0 and returns true; 
   // if no such node exists, returns false. 
   {
      if (node == null){
         found = false;
      } else if (comp.compare(target, node.getInfo()) < 0) {
         node.setLeft(recRemove(target, node.getLeft()));
      } else if (comp.compare(target, node.getInfo()) > 0) {
         node.setRight(recRemove(target, node.getRight()));
      } else {
         node = removeNode(node);
         found = true;
      }
      return node;
   }
   
   








}