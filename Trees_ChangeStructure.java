import java.util.*;

public class Trees_ChangeStructure extends BinaryTree {
	/*669. Trim a Binary Search Tree
	 * Given a binary search tree and the lowest and highest boundaries as L and R,
	 * trim the tree so that all its elements lies in [L, R] (R >= L).
	 * You might need to change the root of the tree, so the result should 
	 * return the new root of the trimmed binary search tree.
	 * Input: 
		   3
		   / \
		  0   4
		   \
		    2
		   /
		  1
		
		  L = 1
		  R = 3
		
		Output: 
		      3
		     / 
		   2   
		  /
		 1
	 */
	public static Node trimBST(Node root, int L, int R) {
        
        if(root == null) return root;
        if(root.data > R) return trimBST(root.left, L, R);
        if(root.data < L) return trimBST(root.right, L, R);
        
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

	/*226. Invert Binary Tree
	 * 
	 * 
		Example:
		
		Input:
		
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		Output:
		
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
	*/
	
	public static Node invertTree(Node root) {
        if(root == null) return root;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }
	
	/*653. Two Sum IV - Input is a BST
	 * 
	 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

		Example 1:
		Input: 
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		
		Target = 9
		
		Output: True
	 */
	public static boolean findTarget(Node root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        return findTargetHelper(root,k,set);               
    }
    
    public static boolean findTargetHelper(Node root, int k, HashSet<Integer> set)
    {
        if (root == null) return false;
        if(set.contains(k-root.data))
            return true;
        set.add(root.data);
        
        return (findTargetHelper(root.left,k,set) || findTargetHelper(root.right,k,set));
    }
	public static void main(String[] args) {
		

	}

}
