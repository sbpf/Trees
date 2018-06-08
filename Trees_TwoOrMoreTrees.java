
public class Trees_TwoOrMoreTrees extends BinaryTree {

	/*617. Merge Two Binary Trees
	 * Given two binary trees and imagine that when you put one of them to cover the other,
	 *  some nodes of the two trees are overlapped while the others are not.
		You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
		then sum node values up as the new value of the merged node. Otherwise,
		the NOT null node will be used as the node of new tree.
	 */
	/*Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
	Output: 
	Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7*/
	
	public static Node mergeTrees(Node t1, Node t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        
        t1.data = t1.data + t2.data;        
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
	
	/*
     * 100. Same Tree
     * Given two binary trees, write a function to check if they are the same or not.

		Two binary trees are considered the same if they are structurally identical and the nodes have the same dataue.

		Example 1:
		
		Input:     1         1
		          / \       / \
		         2   3     2   3
		
		        [1,2,3],   [1,2,3]
		
		Output: true
     */
    public boolean isSameTree(Node p, Node q) 
    {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        if(p.data != q.data) return false;
        
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
