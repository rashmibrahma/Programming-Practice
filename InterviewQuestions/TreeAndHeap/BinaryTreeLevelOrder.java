package interviewQuestions;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as [[3], [9,20], [15,7]]
 */
public class BinaryTreeLevelOrder {
	public ArrayList<ArrayList<TreeNode>> levelOrder(TreeNode root){
		if(root==null){
			return null;
		}
		ArrayList<ArrayList<TreeNode>> result=new ArrayList<ArrayList<TreeNode>>();
		LinkedList<TreeNode> current=new LinkedList<TreeNode>();
		current.add(root);
		LinkedList<TreeNode> parents;
		while(current.size()>0){
			parents=current;
			current=new LinkedList<TreeNode>();
			ArrayList<TreeNode> temp=new ArrayList<TreeNode>();
			for(TreeNode aParent:parents){
				if(aParent.left!=null){
					current.add(aParent.left);
				}
				if(aParent.right!=null){
					current.add(aParent.right);
				}
				temp.add(aParent);
			}
			result.add(temp);
		}
		return result;
	}
}
