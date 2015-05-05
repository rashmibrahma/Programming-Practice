package linkedLists;

public class LLNode<A> {
	private A data;
	private LLNode<A> next;
	
	public LLNode(A data){
		this.data=data;
		this.next=null;
	}

	public A getData() {
		return data;
	}

	public void setData(A data) {
		this.data = data;
	}

	public LLNode<A> getNext() {
		return next;
	}

	public void setNext(LLNode<A> next) {
		this.next = next;
	}
	
}
