package interviewQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.

For example, given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as [[15,7], [9,20],[3]]
 */
public class BinaryTreeLevelOrderII {
	public ArrayList<ArrayList<TreeNode>> levelOrder(TreeNode root){
		if(root==null){
			return null;
		}
		ArrayList<ArrayList<TreeNode>> result=new ArrayList<ArrayList<TreeNode>>();
		Stack<ArrayList<TreeNode>> s=new Stack<ArrayList<TreeNode>>();
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
			s.push(temp);
		}
		
		while(!s.isEmpty()){
			ArrayList<TreeNode> temp=s.pop();
			result.add(temp);
		}
		return result;
	}
}
