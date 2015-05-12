package testquestions;

import java.util.ArrayList;

import queue.Queue;

public class BinaryNode {

	private String desc;
	private BinaryNode leftNode = null;
	private BinaryNode rightNode = null;
	
	public BinaryNode(String desc) {
		this.desc = desc;
	}
	
	public BinaryNode(BinaryNode node, String newDesc){
		this.desc=newDesc;
		this.leftNode=node.getLeftNode();
		this.rightNode=node.getRightNode();
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setLeftNode(BinaryNode node){
		this.leftNode=node;
	}
	
	public BinaryNode getLeftNode() {
		return leftNode;
	}
	
	public void setRightNode(BinaryNode node){
		this.rightNode=node;
	}
	
	public BinaryNode getRightNode() {
		return rightNode;
	}
	
	/**
	 * Find any node within the "originalTree" that has the description matching "oldDesc" 
	 * and correctly replace that single node with a new node containing "newDesc", 
	 * maintaining the tree above and below the replaced node.  It is important that the node 
	 * is a new object and not simply a changed description.  
	 * 
	 * @param originalTree  Root node of the tree
	 * @param oldDesc String that identifies the nodes to replace.  
	 * @param newDesc The description of the new nodes to be placed within the tree.
	 */
	
	public static void replaceNode(BinaryNode originalTree, String oldDesc, String newDesc){
		if(originalTree==null){
			return;
		}
		if(originalTree.getLeftNode()!=null && originalTree.getLeftNode().getDesc().equals(oldDesc)){
			originalTree.setLeftNode(new BinaryNode(originalTree.getLeftNode(),newDesc));
		}
		if(originalTree.getRightNode()!=null && originalTree.getRightNode().getDesc().equals(oldDesc)){
			originalTree.setRightNode(new BinaryNode(originalTree.getRightNode(),newDesc));
		}
		replaceNode(originalTree.getLeftNode(), oldDesc, newDesc);
		replaceNode(originalTree.getRightNode(), oldDesc, newDesc);
	}
	
	public static void printLevel(BinaryNode root){
		if(root==null){
			System.out.println("root is null");
			return;
		}
		Queue<BinaryNode> Q=new Queue<BinaryNode>();
		Q.enQueue(root);
		while(!Q.isEmpty()){
			BinaryNode temp=Q.deQueue();
			System.out.print(temp.getDesc()+"\t");
			for(BinaryNode children:getChildren(temp)){
				Q.enQueue(children);
			}
		}
	}
	
	private static ArrayList<BinaryNode> getChildren(BinaryNode parent) {
		ArrayList<BinaryNode> nodeList=new ArrayList<BinaryNode>();
		if(parent.getLeftNode()!=null){
			nodeList.add(parent.getLeftNode());
		}
		if(parent.getRightNode()!=null){
			nodeList.add(parent.getRightNode());
		}
		return nodeList;
	}

	public static void main(String[] args){
		BinaryNode BT=new BinaryNode("one"); 
		BT.setLeftNode(new BinaryNode("two"));
		BT.setRightNode(new BinaryNode("three"));
		BT.getLeftNode().setLeftNode(new BinaryNode("four"));
		BT.getRightNode().setLeftNode(new BinaryNode("one"));
		BT.getLeftNode().setRightNode(new BinaryNode("five"));
		BT.getLeftNode().getRightNode().setRightNode(new BinaryNode("one"));
		printLevel(BT);
		
		/*
		 * The method "replaceNode" only replaces all nodes below the root node. Because of this, we need to add a dummy node with the root as its child.
		 * We can add an additional method to handle the root, however, the passed variable originalTree is a variable local to the method, so the root of the original
		 * tree will not change. 
		 * 
		 * If we want to avoid adding a dummy node, we need to return the root of the tree from the called method.
		 */
		BinaryNode dummyNode=new BinaryNode(null);
		dummyNode.setRightNode(BT);
		replaceNode(dummyNode, "one", "six");
		BT=dummyNode.getRightNode();
		System.out.println();
		printLevel(BT);
	}

}
