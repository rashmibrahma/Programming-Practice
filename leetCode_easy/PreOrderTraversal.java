package leetCode_easy;

import java.util.ArrayList;
import java.util.List;

import stack.Stack;

public class PreOrderTraversal {
    /*public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root!=null){
        	list.add(root.val);
        	List<Integer> left=preorderTraversal(root.left);
        	List<Integer> right=preorderTraversal(root.right);
        	list.addAll(left);
        	list.addAll(right);
        }
        return list;
    }*/
    
    public static List<Integer> preorderTraversal(TreeNode root){
    	List<Integer> result=new ArrayList<Integer>();
    	if(root==null){
    		return result;
    	}
    	Stack<TreeNode> s=new Stack<TreeNode>();
    	s.push(root);
    	//result.add(root.val);
    	TreeNode temp;
    	while(!s.isEmpty()){
    		temp=s.pop();
    		if(temp!=null){
    			result.add(temp.val);
    			s.push(temp.right);
    			s.push(temp.left);
    		}
    	}
    	return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		TreeNode root=new TreeNode(1);
		//root.left=new TreeNode(2);
		root.left=null;
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(3);
		root.right.right=null;
		list=preorderTraversal(root);
		System.out.print("[");
		for(Integer i:list){
			System.out.print(i+" ");
		}
		System.out.print("]");
	}

}
