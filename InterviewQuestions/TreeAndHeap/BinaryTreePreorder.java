package interviewQuestions;
import java.util.Stack;

/*
 * public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
 */

public class BinaryTreePreorder {
	public void preorderIterative(TreeNode n){
		if(n==null){
			throw new IllegalArgumentException();
		}
		Stack<TreeNode> s=new Stack<TreeNode>();
		s.push(n);
		while(!s.isEmpty()){
			TreeNode temp=s.pop();
			System.out.print(temp.val);
			if(temp.right!=null){
				s.push(temp.right);
			}
			if(temp.left!=null){
				s.push(temp.left);
			}
		}
	}
	
	public void preorderRecursive(TreeNode n){
		if(n==null){
			return;
		}
		System.out.print(n.val);
		preorderRecursive(n.left);
		preorderRecursive(n.right);
	}
}
