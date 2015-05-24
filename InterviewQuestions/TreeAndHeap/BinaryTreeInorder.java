package interviewQuestions;
import java.util.Stack;

public class BinaryTreeInorder {
	public void inorderIterative(TreeNode n){
		if(n==null){
			throw new IllegalArgumentException();
		}
		Stack<TreeNode> s=new Stack<TreeNode>();
		TreeNode p=n;
		while(!s.isEmpty() || p!=null){
			if(p!=null){
				s.push(p);
				p=p.left;
			}
			else{
				TreeNode temp=s.pop();
				System.out.print(temp.val);
				p=temp.right;
			}
		}
	}
	
	public void inorderRecursive(TreeNode n){
		if(n==null){
			return;
		}
		inorderRecursive(n.left);
		System.out.print(n.val);
		inorderRecursive(n.right);
	}
}
