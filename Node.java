//Alexander Kim and Robert Palko
//CIS 112 ONLN2 Final Project
//Jason Wertz

/********************
 * The Node class mimics the book's BSTNode. 
 * It is created here because interviews will not
 *    have this book's data available to us :)
 ********************/

class Node<T>{
   
   public T info;
   Node left;
   Node right;
   
   public Node(T info){    
      this.info = info;
      left = null;
      right = null;
   }
   
   public void setLeft(Node node){
      left = node;
   }
   
   public void setRight(Node node){
      right = node;
   }
   
   public T getInfo(){
      return info;
   }
   
   public Node getLeft(){
      return left;
   }
   
   public Node getRight(){
      return right;
   }
}

/********************
 * This is the main "driver" of our interview question.
 * It creates a tree that maintains the BST property,
 *    rearranges the pointers so the elements are in line
 *    and the front is the lowest element.
 * It then prints the resulting DLL.
 ********************/
class BSTtoDLL{

   // pointer Nodes
   static Node previous = null;
   static Node current = null;
   
   public static void main(String[] args){
      
      // manually make tree
      // set root
      Node<Integer> root = new Node<Integer>(4);
      // set level 1
      root.setLeft(new Node<Integer>(2));
      root.setRight(new Node<Integer>(6));
      // set level 2
      root.getLeft().setLeft(new Node<Integer>(1));
      root.getLeft().setRight(new Node<Integer>(3));
      root.getRight().setLeft(new Node<Integer>(5));
      root.getRight().setRight(new Node<Integer>(7));
      // set level 3
      root.getRight().getRight().setRight(new Node<Integer>(9));
      
      // traverse is an inOrder iterator    
      traverse(root);
      
      // setPointer moves the pointer to the leftmost node, which is the head of the list
      root = setPointer(root);
      
      // print the resulting list
      printDLL(root);
   }
   
   /********************
    * The traverse method is an in order traversal
    ********************/
   public static void traverse(Node root){
      
      if (root != null){
         
         // travel down the leftmost side
         traverse(root.getLeft());
         // convert the root node
         convert(root);
         // travel to the right node
         traverse(root.getRight());
      }
   }
   
   /********************
    * Convert shifts the left and right pointers to their
    *    new nodes based off the traversal method. Since our
    *    binary tree is a binary search tree, the elements will be
    *    in ascending order.   
    ********************/   
   public static void convert(Node root){
      
      // move the previous pointer to the last working spot
      previous = current;
      
      // update the current pointer to the active node
      current = root;
      
      // set the left link to the previous node
      current.setLeft(previous);
      
      // avoids a null pointer exception on the first node
      // and sets the previous node's right pointer to this node
      if (previous != null)
         previous.setRight(current); 
   }
   
   /********************
    * setPointer moves the root variable to the 
    * leftmost element of the list.
    ********************/    
   public static Node setPointer(Node node){
      
      // go left until we cannot
      while (node.getLeft() != null)
         node = node.getLeft();
         
      return node;
   }
   
   /********************
    * Simply prints the resulting order of the elements 
    ********************/    
   public static void printDLL(Node node){
      
      // print the info and get the right node
      if (node != null){
         System.out.print(node.getInfo() + "\t");
         printDLL(node.getRight());
      }
   }  
}