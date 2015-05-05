package stack;
import linkedLists.*;

public class Stack<A> {
	public SinglyLinkedList<A> stack;
	public LLNode<A> top=null;
	
	public Stack(){
		stack=new SinglyLinkedList<A>();
	}
	
	public void push(A element){
		if(stack.head==null){
			stack.head=new LLNode<A>(element);
			top=stack.head;
			return;
		}
		LLNode<A> currentNode=stack.head;
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
		}
		currentNode.setNext(new LLNode<A>(element));
		top=currentNode.getNext();
	}
	
	public A pop(){
		
		if(top==null)
			return null;
		
		LLNode<A> currentNode=stack.head;
		
		if(currentNode.getNext()==null){
			A temp=currentNode.getData();
			top=null;
			stack.head=null;
			return temp;
		}
		while(currentNode.getNext()!=top){
			currentNode=currentNode.getNext();
		}
		A elementPop=top.getData();
		currentNode.setNext(null);
		top=currentNode;
		return elementPop;
	}
	
	public A peek(){
		
		if(top==null){
			return null;
		}
		return top.getData();
	}
	
	public LLNode<A> top(){
		return top;
	}
	
	public boolean isEmpty(){
		if(top==null)
			return true;
		return false;
	}
	
	public void printStack(){
		LLNode<A> currentNode=stack.head;
		if(currentNode==null){
			System.out.println("invalid");
			return;
		}
		
		while(currentNode!=null){
			System.out.print(currentNode.getData()+"->");
			currentNode=currentNode.getNext();
		}
		System.out.print("null");
		System.out.println();
	}
	
}
