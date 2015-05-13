package leetCode_easy;

import java.util.Stack;

import treesAndGraphs.TreeNode;

public class TernaryToTree {

	public static BinaryNode ternaryToTree(String exp){
		if(exp==null){
			return null;
		}
		Stack<BinaryNode> terStack=new Stack<BinaryNode>();
		char[] expArr=exp.toCharArray();
		
		int i=1, len=exp.length();
		BinaryNode root=new BinaryNode(expArr[0]);
		terStack.push(root);
		BinaryNode current=root;
		while(!terStack.isEmpty()){
			if(i<len){
				if(expArr[i]=='?'){
					current.left=new BinaryNode(expArr[i+1]);
					terStack.push(current.left);
					current=current.left;
				}
				else if(expArr[i]==':'){
					while(current.right!=null){
						current=terStack.pop();	
					}
					if(current.right==null){
						current.right=new BinaryNode(expArr[i+1]);
						terStack.push(current.right);
						current=current.right;
					}
				}
				i=i+2;
			}
			else{
				terStack.pop();
			}
		}
		return root;
	}
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		BinaryNode root=ternaryToTree("a?b:c?d:e");
		preOrderTraversal(root);
	}
	public static void preOrderTraversal(BinaryNode root){
		if(root==null)
			return;
		System.out.print(root.val+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	
	}

}
