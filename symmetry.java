import java.util.*;

class symmetry extends BinaryTree{	
	
	    public static boolean isSymmetric (Node root) {

	        if(root == null) return true;
	        
	        List<Integer> leftTree = new ArrayList<Integer>();
	        List<Integer> rightTree = new ArrayList<Integer>();
	        
	        leftTree = traverse(root.left,leftTree);
	        rightTree = traverse(root.right,rightTree);
	        
	        System.out.println(leftTree);
	        System.out.println(rightTree);
	        
	        if(leftTree.size() != rightTree.size()) return false;
	        
	        int max_size = leftTree.size();
	        int i=0;        
	        while(i<max_size)
	        {
	            if(leftTree.get(i) != rightTree.get((max_size-1) - i))
	                return false;            
	            i++;
	        }
	        return true;
	    }
	    
	    public static List<Integer> traverse(Node root, List<Integer> list)
	    {
	        if(root == null)
	        { 
	           return list; 
	        }             
	        
	       if(root.left!=null)
	            list = traverse(root.left,list);
	       else if(root.left==null && root.right!=null)
	            list.add(0);
	        
	        list.add(root.data);
	        
	       if(root.right!=null)
	            list = traverse(root.right,list);
	       else if(root.right==null && root.left!=null)
	            list.add(0);
	        
	        return list;
	    }
	
//Alternate Leetcode: simple one
	/*    class Solution {
	        public boolean isSymmetric(TreeNode root) {
	            if(root == null)
	            {
	                return true;
	            }        
	            return isSymmetric(root,root);        
	        }
	        
	        public boolean isSymmetric(TreeNode t1, TreeNode t2)
	        {
	            if(t1==null && t2 == null) return true;
	            if(t1==null||t2 == null) return false;
	            return ((t1.val == t2.val) && isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left));
	        }      
	    }
	    */
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		Node root = null;
		//[5,4,1,null,1,null,4,2,null,2,null]
		root=tree.insertNode(root, 5);
		root=tree.insertNode(root, 4);
		root=tree.insertNode(root, 1);
		root=tree.insertNode(root, 0);
		root=tree.insertNode(root, 1);
		root=tree.insertNode(root, 4);
		root=tree.insertNode(root, 2);
		root=tree.insertNode(root, 0);
		root=tree.insertNode(root, 2);
		root=tree.insertNode(root, 0);
		System.out.println(isSymmetric(root));
	}
	
}