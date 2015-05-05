package queueUsingStack;
import stack.*;

public class QueueUsingStack<A> {
	Stack<A> S = new Stack<A>();
	Stack<A> STemp = new Stack<A>();
	
	public void enQueue(A element){
		S.push(element);
	}
	
	public A deQueue(){
	
		A temp;
		
		if(S.isEmpty())
			return null;
		if(S.peek()==S.top){
			temp=S.top.getData();
			S.top=null;
			return temp;
		}
		while(!S.isEmpty()){
			temp=S.pop();
			STemp.push(temp);
		
		}
		temp=STemp.pop();
		
		while(!STemp.isEmpty()){
			S.push(STemp.pop());
		}
		return temp;
		
	}
	
	public void printQueue(){
		if(S.peek()==null){
			System.out.println("Empty");
			return;
		}
		S.printStack();
	}
	
	public void printQueueTemp(){
		if(STemp.peek()==null)
		{
			System.out.println("Empty");
			return;
		}
		
		STemp.printStack();
	}
}
