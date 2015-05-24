package interviewQuestions;
import java.util.ArrayList;
import java.util.LinkedList;

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
