
public class SumPath extends BinaryTree {
	
	public boolean hasPathSum(Node root, int sum)
	{
        if(root == null) return false;
        
        if(sum == root.data && root.left == null && root.right == null)
            return true;       
        
        return(hasPathSum(root.left,sum-root.data) || hasPathSum(root.right,sum-root.data));
    }
		
	public static void main(String[] args)
	{
		SumPath s = new SumPath();
		Node root = null;
		
		// test case: true: [5,4,8,11,null,13,4,7,2,null,null,null,1]
		root = s.insertNode(root, 5);
		root = s.insertNode(root, 4);
		root = s.insertNode(root, 8);
		root = s.insertNode(root, 11);
		root = s.insertNode(root, 0);
		root = s.insertNode(root, 13);
		root = s.insertNode(root, 4);
		root = s.insertNode(root, 7);
	}	
}
