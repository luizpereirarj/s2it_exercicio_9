package s2it.exercicio9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This application creates a binary tree.
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Inform the first number for the binary tree: ");
    	int value=scanner.nextInt();
    	BinaryTree tree= new BinaryTree(value);
       while (value!=0) {
    	  System.out.println("Inform the next number for the binary tree or 0 to sum and exit: ");
    	  value=scanner.nextInt();
    	  if (value!=0) {
    	  tree.insertValue(value);
    	  }
       }
        
       System.out.println("Inform the number of the binary tree which you would like to sum subsequences numbers: ");
       	int number=scanner.nextInt();
        scanner.close();
    	
        tree.sumAllSubsequencesByTree(tree.searchValue(number));
    	
    	
    	
    }
    
    
   
    
   
    
    
}
