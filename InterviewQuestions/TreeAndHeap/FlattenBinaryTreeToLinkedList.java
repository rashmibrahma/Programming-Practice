package interviewQuestions;
import java.util.Stack;
/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
/*
 * public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if(root==null){
			throw new IllegalArgumentException();
		}
		Stack<TreeNode> s=new Stack<TreeNode>();
		TreeNode p=root;
		while(p!=null && !s.isEmpty()){
			if(p.right!=null){
				s.push(p.right);
			}
			if(p.left!=null){
				p.right=p.left;
				p.left=null;
			}
			else{
				p.right=s.pop();
			}
			p=p.right;
		}
	}
}
