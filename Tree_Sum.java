
public class Tree_Sum extends BinaryTree{
	/*404. Sum of Left Leaves
	 * Find the sum of all left leaves in a given binary tree.

		Example:
		
		    3
		   / \
		  9  20
		    /  \
		   15   7

		There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
	 * 
	 */
	
	public boolean isLeafNode(Node node)
    {
        if(node == null) return false;
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
    public int sumOfLeftLeaves(Node root) {        
        if(root == null) return 0;
        
        int sum = 0;
        if(isLeafNode(root.left))
            sum += root.left.data;
        else
            sum += sumOfLeftLeaves(root.left);
        
        sum += sumOfLeftLeaves(root.right);
        
        return sum;           
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
