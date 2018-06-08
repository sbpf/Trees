import java.util.*;

public class BinaryTree {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public Node insertNode(Node root, int data)
	{
		if(root==null)
			root = new Node(data);			
		
		else if(data<=root.data)
			root.left = insertNode(root.left,data);

		else 
			root.right = insertNode(root.right,data);			
		return root;
	}
	
	public void inOrderTraversal(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	public void preOrderTraversal(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public void postOrderTraversal(Node root)
	{
		if(root==null)
		{
			return;
		}
				
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
	}
	
	public void levelOrderTraversal(Node root)
	{
		if(root == null)
		{
			return;
		}
		
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		
		while(!Q.isEmpty())
		{
			Node temp = Q.remove();
			System.out.println(temp.data);
			if(temp.left != null)
			{
				Node left = temp.left;
				Q.add(left);
			}
			if(temp.right != null)
			{
				Node right = temp.right;
				Q.add(right);
			}
		}		
	}
	
	public List<List<Integer>> levelOrderLists(Node root)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();				
		return levelOrderLists(root,list);		
	}
	
	public List<List<Integer>> levelOrderLists(Node root, List<List<Integer>> list)
	{
		if(root == null)
			return list;
		
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		
		while(!Q.isEmpty())
		{
			int levelNodes = Q.size();
			List<Integer> tempList = new ArrayList<Integer>();
			
			while(levelNodes>0)
			{
				Node temp = Q.remove();
				tempList.add(temp.data);
				if(temp.left!=null) Q.add(temp.left);
				if(temp.right!=null) Q.add(temp.right);
				levelNodes--;				
			}
			list.add(tempList);
		}
		
		return list;
	}
	
	//Maximum Depth Top Down Approach
	public int maximumDepth(Node root)
	{	
		int depth = -1;
		if(root==null) return depth;
		return maximumDepth(root,0,-1);
	}
	
	private int maximumDepth(Node root, int depth, int maxDepth)
	{
		if(root == null)
		{
			return 0;
		}
		
		else if(root.left == null && root.right == null)
		{
			maxDepth = maxDepth>(depth+1) ? maxDepth:depth+1;
			return maxDepth;
		}
			
		maxDepth = maximumDepth(root.left,depth+1,maxDepth);
		maxDepth = maximumDepth(root.right,depth+1,maxDepth);
		return maxDepth;
	}

	//Maximum Depth Bottom-up Approach
	public int maxDepth(Node root)
	{
		if(root == null) return 0;
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return Math.max(leftDepth, rightDepth)+1;
		
	}
	/*public static void main(String[] args)
	{ 
		BinaryTree tree = new BinaryTree();
		
		Node root = null;
		root = tree.insertNode(root,10);
		root = tree.insertNode(root,5);
		root = tree.insertNode(root,20);
		root = tree.insertNode(root,4);
		root = tree.insertNode(root,8);
		root = tree.insertNode(root,12);
		root = tree.insertNode(root,25);
		root = tree.insertNode(root, 27);
		System.out.println("InOrder Traversal:");
		tree.inOrderTraversal(root);
		
		System.out.println("PreOrder Traversal");
		tree.preOrderTraversal(root);
		
		System.out.println("PostOrder Traversal");
		tree.postOrderTraversal(root);
		
		System.out.println("Level Order Traversal");
		tree.levelOrderTraversal(root);		
		
		System.out.println("Level Order Traversal Level-wise");
		System.out.println(tree.levelOrderLists(root));
		
		System.out.println("Maximum Depth of the tree:");
		System.out.println(tree.maximumDepth(root));
		
		System.out.println("Maximum Depth of a tree Bottom-up");
		System.out.println(tree.maxDepth(root));
	}*/

}
