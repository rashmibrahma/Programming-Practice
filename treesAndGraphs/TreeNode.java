package treesAndGraphs;

public class TreeNode<A> {
	A data;
	TreeNode<A> right;
	TreeNode<A> left;
	
	public TreeNode(A data){
		this.data=data;
		right=null;
		left=null;
	}
	public A getData() {
		return data;
	}
	public void setData(A data) {
		this.data = data;
	}
	public TreeNode<A> getRight() {
		return right;
	}
	public void setRight(TreeNode<A> right) {
		this.right = right;
	}
	public TreeNode<A> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<A> left) {
		this.left = left;
	}
	

}
