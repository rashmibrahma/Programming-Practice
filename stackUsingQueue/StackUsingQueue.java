package stackUsingQueue;
import java.security.acl.LastOwnerException;

import queue.*;

public class StackUsingQueue<A> {
	
	Queue<A> Q=new Queue<A>();
	
	/*private Node<A> lastNode(){
		if(Q.head==null)
			return null;	//empty queue
		if(Q.head.getNext()==null)
			return Q.head;
		Node<A> currentNode=Q.head;
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
		}
		return currentNode;
	}*/
	
	/*public void Stack(){
		Node<A> lastNode=lastNode();
		Node<A> currentNode=Q.head, tempNode=lastNode;
	}*/
	
	public void push(A element){
		Queue<A> Q1=new Queue<A>();
		Q1.enQueue(element);
		while(!Q.isEmpty()){
			Q1.enQueue(Q.deQueue());
		}
		while(!Q1.isEmpty()){
			Q.enQueue(Q1.deQueue());
		}
	}
	
	public A pop(){
		return Q.deQueue();
	}
	
	public void printQueue(){
		if(Q.head==null)
		{
			System.out.println("Empty");
			return;
		}
		Node<A> currentNode=Q.head;
		while(currentNode!=null){
			System.out.print(currentNode.getData()+"<-");
			currentNode=currentNode.getNext();
		}
		System.out.println();
	}

}
