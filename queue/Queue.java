package queue;

import queue.Node;

public class Queue<A> {
	public Node<A> head;
	private int listCount;
	
	/*
	 * define a constructor to show each node type and links between the two nodes
	 */
	public Queue(){
		head = null;
		listCount = 0;
	}
	
	//method to add objects in the end of the Queue
	//A --> B --> C --> D -->
	//add to D and remove from A.
	public void enQueue(A dataValue){
		Node<A> tempNode = new Node<A>(dataValue);
		Node<A> currentNode = head;
		
		if(listCount==0 || head==null){
			head=tempNode;
			listCount++;
			return;
		}
		while(currentNode.getNext()!=null){
			currentNode = currentNode.getNext();
			//System.out.println("*************");
		}
		currentNode.setNext(tempNode);
		//increment the count of items in the list
		listCount++;
	}
	
	//A --> B --> C --> D -->
	//add to D and remove from A.
	public A deQueue(){
		
		if(head==null){
			System.out.println("Nothing to de-queue...Queue is empty");
			return null;
		}
		A temp=(A) head.getData();
		head=head.getNext();
		return temp;
	}
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void printQueue(){
		if(head==null)
		{
			System.out.println("Empty");
			return;
		}
		Node<A> currentNode=head;
		while(currentNode!=null){
			System.out.print(currentNode.getData()+"<-");
			currentNode=currentNode.getNext();
		}
		System.out.println();
	}
}
