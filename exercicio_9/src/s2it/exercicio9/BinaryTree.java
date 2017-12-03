package s2it.exercicio9;

import java.util.ArrayList;
import java.util.List;

/**
 * This classe represents a Binary Tree entity
 * @author Luiz Felipe
 *
 */
public class BinaryTree {

	/**
	 * Value of binary tree
	 */
	private int value;
	/**
	 * BinaryTree left with the value less than the current
	 */
	private BinaryTree left;
	/**
	 * BinaryTree left with the value greater than the current
	 */
	private BinaryTree right;

	/**
	 * Constructor
	 * 
	 * @param newValue New Value for the binary tree
	 */
	public BinaryTree(int newValue) {
		this.value = newValue;
	}

	/**
	 * Value of binary tree
	 * @return The value of binary tree
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Insert value of binary tree
	 * @param value The value of binary tree
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Binary tree on Left
	 * @return The  binary tree on left.
 	 */
	public BinaryTree getLeft() {
		return left;
	}
	
	/**
	 * Insert binary tree on left
	 * @param left The binary tree on left
	 */
	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	/**
	 * Binary tree on Right
	 * @return The  binary tree on right.
 	 */
	public BinaryTree getRight() {
		return right;
	}

	/**
	 * Insert binary tree on right
	 * @param left The binary tree on right
	 */
	public void setRight(BinaryTree right) {
		this.right = right;
	}

	/**
	 * Insert value on binary tree. This value can be on left or right depending on if it is less or greater than the current value.
	 * @param value The value of binary tree
	 */
	public void insertValue(int valor) {

	        
	        if (valor < this.getValue()) {
	            if (this.getLeft() != null) {
	                this.getLeft().insertValue(valor);
	            } else {
	                this.setLeft(new BinaryTree(valor));
	            }
	        } else if (valor > this.getValue()) {
	            if (this.getRight() != null) {
	                this.getRight().insertValue(valor);
	            } else {
	                this.setRight(new BinaryTree(valor));
	            }
	        }
	     
	}

	/**
	 * Search a binary tree by value
	 * @param value The value of binary tree which will be searched for.
	 */
	public BinaryTree searchValue(int value) {

		if (value == this.getValue()) {
			return this;
		} else {
			if (value > this.getValue()) {
				if (this.getRight() == null) {
					return null;
				}
				return this.getRight().searchValue(value);
			} else {
				if (this.getLeft() == null) {
					return null;
				}
				return this.getLeft().searchValue(value);
			}
		}
	}

	
	/**
	 * Collect subsequences of a binary tree by a specific one
	 * @param tree The binary tree starting point
	 * @param total The sum of all subsequences values.
	 */
	public  void collectNumberByTree(BinaryTree tree, List<Integer> subsequences) {
        if(tree != null){
        	if (subsequences.size()==0) {
        		subsequences.add(tree.getValue());
            	if (tree.getLeft()!=null) {
            		subsequences.add(tree.getLeft().getValue());
            	}
            	if (tree.getRight()!=null) {
            		subsequences.add(tree.getRight().getValue());
            	}
            }else {
            	if (tree.getLeft()!=null) {
            		subsequences.add(tree.getLeft().getValue());
            	}
            	if (tree.getRight()!=null) {
            		subsequences.add(tree.getRight().getValue());
            	}
            }
        	if (tree.getLeft()!=null) {
        		collectNumberByTree(tree.getLeft(),subsequences);
        	}
        	if (tree.getRight()!=null) {
        		collectNumberByTree(tree.getRight(),subsequences);
        	}
        	        	
        }
    }
	
	/**
	 * Sum all elements collectes by a specific binary tree
	 * @param tree Binarry tree which subsequences will be summed.
	 */
	public void sumAllSubsequencesByTree(BinaryTree tree) {
		ArrayList<Integer> subsequences=new ArrayList<Integer>();
    	tree.collectNumberByTree(tree,subsequences);
    	int total=0;
    	for (Integer number:subsequences) {
    		total=total+number;
    	}
    	System.out.println("Total:"+total);
	}

}
