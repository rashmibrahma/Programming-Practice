package treesAndGraphs;
import stack.Stack;

public class Tree<A> {
	TreeNode<A> root;
	
	public TreeNode<A> addNode(A data){
		if(root==null)
		{
			root=new TreeNode<A>(data);
			return root;
		}
		return root;
			
	}
	
	public void addLeftNode(A data){
		TreeNode<A> newNode=new TreeNode<A>(data);
		TreeNode<A> currentNode=root;
		while(currentNode.getLeft()!=null){
			currentNode=currentNode.getLeft();
		}
		currentNode.setLeft(newNode);
	}
	
	public void addRightNode(A data){
		TreeNode<A> newNode=new TreeNode<A>(data);
		TreeNode<A> currentNode=root;
		while(currentNode.getRight()!=null){
			currentNode=currentNode.getRight();
		}
		currentNode.setRight(newNode);
	}
	
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}
	public void preOrderTraversal(TreeNode<A> root){
		if(root==null)
			return;
		System.out.print(root.getData()+" ");
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}
	public void preOrderTraversalIterative(){
		Stack<TreeNode<A>> S = new Stack<TreeNode<A>>();
		S.push(root);
		TreeNode<A> temp=root;
		while(!S.isEmpty()){
			temp=S.pop();
			if(temp!=null)
			{
				System.out.print(temp.getData()+" ");
				S.push(temp.getRight());
				S.push(temp.getLeft());
			}
		}
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	public void inOrderTraversal(TreeNode<A> root){
		if(root==null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.getData()+" ");
		inOrderTraversal(root.getRight());
	}
	public void inOrderTraversalIterative(){
		Stack<TreeNode<A>> S=new Stack<TreeNode<A>>();
		TreeNode<A> currentNode=root;
		boolean done=false;
		while(!done){
			if(currentNode!=null){
				S.push(currentNode);
				currentNode=currentNode.getLeft();
			}
			else{
				if(S.isEmpty())
					done=true;
				else{
					currentNode=S.top().getData();
					System.out.print(S.pop().getData()+" ");
					currentNode=currentNode.getRight();
				}
			}
		}
		
	}
	
	public void postOrderTraversal(){
		postOrderTraversal(root);
	}
	public void postOrderTraversal(TreeNode<A> root){
		if(root==null)
			return;
		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		System.out.print(root.getData()+" ");
	}
	public void postOrderTravesalIterative(){
		Stack<TreeNode<A>> S=new Stack<TreeNode<A>>();
		if(root==null)
			return;
		S.push(root);
		TreeNode<A> prev=null;
		TreeNode<A> current;
		while(!S.isEmpty()){
			current=S.top().getData();
			if(prev==null || prev.getLeft()==current || prev.getRight()==current){
				if(current.getLeft()!=null)
					S.push(current.getLeft());
				else if(current.getRight()!=null)
					S.push(current.getRight());
				else{
					System.out.print(current.getData()+" ");
					S.pop();
				}
			}
			else if(current.getLeft()==prev){
				if(current.getRight()!=null)
					S.push(current.getRight());
				else{
					System.out.print(current.getRight()+" ");
					S.pop();
				}
			}
			else if(current.getRight()==prev){
				System.out.print(current.getData()+" ");
				S.pop();
			}
			prev=current;
		}
	}

	public boolean isBST(){
		return isBST(root);
	}
	public boolean isBST(TreeNode<A> root){
		if(root==null){
			return true;
		}
		int left=height(root.getLeft());
		int right=height(root.getRight());
		if(Math.abs(left-right) > 1)
			return false;
		else
			return true;
	}
	
	public int height(TreeNode<A> root){
		if(root==null){
			return 0;
		}
		return(Math.max(height(root.left), height(root.right))+1);
	}

}
