
public class Trees_Build extends BinaryTree {

	/*
	 * 108. Convert Sorted Array to Binary Search Tree
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

		For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
		
		Example:		
		Given the sorted array: [-10,-3,0,5,9],		
		One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
		
		      0
		     / \
		   -3   9
		   /   /
		 -10  5
	 * 
	 */
	public Node sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return constructBST(nums,0,nums.length-1);
    }
    public Node constructBST(int[] nums, int low, int high)
    {
        if(low > high)
            return null;
        
        int mid = (low + high) / 2;
        
        Node node = new Node(nums[mid]);
        node.left = constructBST(nums, low, mid-1);
        node.right = constructBST(nums, mid+1, high);
        return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
