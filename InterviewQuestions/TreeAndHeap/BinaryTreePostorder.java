package interviewQuestions;
import java.util.Stack;
import java.util.HashSet;

/*//Definition for binary tree
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}*/
public class BinaryTreePostorder {
	public void postOrderRecursive(TreeNode root){
		if(root==null){
			return;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.val);
	}
	
	public void postOrderIterative(TreeNode root){
		if(root==null){
			throw new IllegalArgumentException();
		}
		Stack<TreeNode> s=new Stack<TreeNode>();
		HashSet<TreeNode> visit=new HashSet<TreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			TreeNode temp=s.pop();
			if(temp.left!=null || temp.right!=null){
				s.push(temp);
				if(temp.right!=null && !visit.contains(temp.right)){
					s.push(temp.right);
				}
				if(temp.left!=null && !visit.contains(temp.left)){
					s.push(temp.left);
				}
				if(visit.contains(temp.left) && visit.contains(temp.right)){
					temp.left=null;
					temp.right=null;
				}
			}
			else if(temp.left==null && temp.right==null){
				System.out.print(temp.val);
				visit.add(temp);
			}
		}
	}
}
