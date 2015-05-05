package treesAndGraphs;

public class TreeOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Tree<Integer> t1=new Tree<Integer>();
		t1.addNode(1);
		t1.addLeftNode(2);
		t1.addRightNode(3);
		TreeNode<Integer> tNode=new TreeNode<Integer>(5);
		t1.root.getLeft().setRight(tNode);
		t1.addLeftNode(4);
		
		System.out.print("Preorder: ");
		t1.preOrderTraversal();
		System.out.println();
		System.out.print("Preorder Iterative: ");
		t1.preOrderTraversalIterative();
		System.out.println();
		System.out.print("Inorder: ");
		t1.inOrderTraversal();
		System.out.println();
		System.out.print("Inorder Iterative: ");
		t1.inOrderTraversalIterative();
		System.out.println();
		System.out.print("Postorder: ");
		t1.postOrderTraversal();
		System.out.println();
		System.out.print("PostOrder Iterative: ");
		t1.postOrderTravesalIterative();
		System.out.println();
		System.out.println(t1.isBST());
		t1.addLeftNode(5);
		System.out.println(t1.isBST());
	}

}
