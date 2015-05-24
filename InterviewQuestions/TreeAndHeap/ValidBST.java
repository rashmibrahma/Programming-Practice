package interviewQuestions;
/*
 * Problem:

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

/*
 * public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

 */
public class ValidBST {
	public boolean isBST(TreeNode root){
		return isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	
	private boolean isBST(TreeNode root,Integer max,Integer min){
		if(root==null){
			return true;
		}
		if(root.val>=max || root.val<min){
			return false;
		}
		return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
	}
}
