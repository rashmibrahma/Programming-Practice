package queueUsingStack;
import stack.*;

public class QueueUsingStackRec<A> {
	Stack<A> S = new Stack<A>();
	Stack<A> STemp = new Stack<A>();
	
	public void enQueue(A element){
		S.push(element);
	}
	
	public A deQueue(){
		return deQueue(S);
	}
	
	public A deQueue(Stack S){
		A x,res;
		if(S.isEmpty())
			return null;
		else if(S.stack.head.getNext()==null){
			return (A) S.pop();			
		}
		else{
			x=(A)S.pop();
			res=deQueue(S);
			S.push(x);
			return res;
		}
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
