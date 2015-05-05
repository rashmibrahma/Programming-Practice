package linkedLists;

public class SinglyLinkedList<A> {

	public LLNode<A> head;
	private static int listLength=0;
	
	public SinglyLinkedList(){
	}
	
	public void addNode(A data){
		if(head==null){
			addHeadNode(data);
			return;
		}
		LLNode<A> newNode=new LLNode<A>(data);
		LLNode<A> currentNode=head;
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
		}
		currentNode.setNext(newNode);
		listLength++;
	}
	
	public void addNode(A data, int index){
		if(head==null){
			System.out.println("invalid");
			return;
		}
		if(index==0){
			addHeadNode(data);
		}
		LLNode<A> newNode=new LLNode<A>(data);
		LLNode<A> currentNode=head;
		for(int i=0; i<index-1; i++){
			currentNode=currentNode.getNext();
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		listLength++;
	}
	
	public void addHeadNode(A data) {
		LLNode<A> newNode=new LLNode<A>(data);
		newNode.setNext(head);
		head=newNode;
		listLength++;
		
	}

	public A deleteNode(int index){
		if(index==0){
			deleteHeadNode();
		}
		LLNode<A> currentNode=head;
		for(int i=0; i<index-1; i++){
			currentNode=currentNode.getNext();
		}
		A temp=currentNode.getNext().getData();
		currentNode.setNext(currentNode.getNext().getNext());
		listLength--;
		return temp;
	}
	
	public A deleteHeadNode(){
		A temp= head.getData();
		head=head.getNext();
		listLength--;
		return temp;
	}
	
	public void printList(){
		LLNode<A> currentNode=head;
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
	
	public int listSize(){
		
		if(head==null){
			System.out.println("invalid");
			return 0;
		}
		
		return listLength;
	}
	
	//get the midpoint index of a linkedList
	public LLNode<A> listMid(){
		LLNode<A> fastPointer=head;
		LLNode<A> slowPointer=head;
		int counter=0;
		if(head==null){
			return head;	//only one node
		}
		while(fastPointer.getNext()!=null){
			slowPointer=slowPointer.getNext();
			fastPointer=fastPointer.getNext().getNext();
			counter++;
			//case for even nodes
			if(fastPointer.getNext()==null){
				break;
			}	
			//case for odd nodes
			else if(fastPointer.getNext().getNext()==null){
				break;
			}
		}
		return slowPointer;
	}
	/*
	public void recReverseList(){
		LLNode<A> tempNode=recReverseList(this.head);
		tempNode.setNext(null);
		LLNode<A> currentNode=head;
		//System.out.println("head"+head.getData());
		if(head==null){
			System.out.println("invalid");
		}
		System.out.println();
		for(int i=0; i<=count; i++){
			System.out.print(currentNode.getData());
			currentNode=currentNode.getNext();
		}
	}
	public LLNode<A> recReverseList(LLNode<A> head){
		count++;
		if(head.getNext().getNext()==null){
			this.head=head.getNext();
			System.out.print("head"+this.head.getData());
			return head;
		}
		recReverseList(head.getNext());
		System.out.print(head.getData());
		head.getNext().setNext(head);
		return head;
	}
	*/
	public LLNode<A> reverseList(){
		if(head.getNext()==null)
			return head;
		LLNode<A> prev=head, next=head.getNext(), temp=next.getNext();
		prev.setNext(null);
		next.setNext(prev);
		prev=next;
		next=temp;
		if(temp!=null){
			temp=next.getNext();
		}
		else{
			head=prev;
			return head;
		}
		while(next!=null){
			temp=next.getNext();
			next.setNext(prev);
			prev=next;
			next=temp;
		}
		head=prev;
		return head;
		
	}
	
	public boolean isPalindrome(){
		if(head==null)
			return false;
		if(head.getNext()==null)	//single node
			return true;
		LLNode<A> tempHead=head;
		LLNode<A> mid=listMid();
		head=mid.getNext();
		
		
		//reverse from this new head
		LLNode<A> secondHead=reverseList();
		mid.setNext(secondHead);
		head=tempHead;
		return(checkPalindrome(head, mid));
	}

	private boolean checkPalindrome(LLNode<A> head, LLNode<A> mid) {
		LLNode<A> afterMid=mid.getNext();
		LLNode<A> beforeMid=head;
		while(beforeMid!=mid){
			if(beforeMid.getData()!=afterMid.getData())
				return false;
			beforeMid=beforeMid.getNext();
			afterMid=afterMid.getNext();
		}
		//check the condition when beforeMid == mid
		if(beforeMid.getData()!=afterMid.getData())
			return false;
		else
			return true;
	}
	
	public void deleteList(){
		head.setNext(head);
		head=null;
	}
	
	public int listLength(){
		if(head==null)
			return 0;
		LLNode<A> current=head;
		int counter=0;
		while(current!=null){
			counter++;
			current=current.getNext();
		}
		return counter;
	}

	public LLNode<A> nthNodeFromEndOfLinkedList(int n){
		LLNode<A> mainPointer=head, refPointer=head;
		int count=0;
		if(head!=null){
			while(count<n){
				if(refPointer==null){
					System.out.println(n+" is greater than the number of nodes in the list");
					return null;
				}
				refPointer=refPointer.getNext();
				count++;
			}
			while(refPointer!=null){
				mainPointer=mainPointer.getNext();
				refPointer=refPointer.getNext();
			}
			return mainPointer;
		}
		return null;
	}
}
