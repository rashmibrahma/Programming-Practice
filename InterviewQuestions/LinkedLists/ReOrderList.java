package interviewQuestions;

public class ReOrderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head=makeList(10);
		printList(head);
		Node result=reOrderList(head);
	}

	private static Node reOrderList(Node head) {
		if(head==null){
			throw new IllegalArgumentException();
		}
		if(head.next==null){
			return head;
		}
		Node midPrev=findMidList(head);
		Node revHead=reverseList(midPrev.next);
		midPrev.next=null;
		Node f_curr=head,s_curr=revHead;
		while(f_curr!=null){
			Node fNext=f_curr.next,sNext=s_curr.next;
			f_curr.next=s_curr;
			if(fNext==null){
				break;
			}
			s_curr.next=fNext;
			f_curr=fNext;
			s_curr=sNext;
		}
		//printList(head);
		return null;
	}

	private static Node reverseList(Node head) {
		if(head.next==null){
			return head;
		}
		Node temp=reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return temp;
	}

	private static Node findMidList(Node head) {
		Node slow=head,fast=head,prev=slow;
		while(slow!=null){
			if(fast==null || fast.next==null){
				break;
			}
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		return prev;
	}

	private static void printList(Node head) {
		Node current=head;
		while(current!=null){
			System.out.print(current.x+"->");
			current=current.next;
		}
		System.out.println();
	}

	private static Node makeList(int n) {
		Node head=new Node(1);
		Node current=head;
		for(int i=1; i<n; i++){
			current.next=new Node(i+1);
			current=current.next;
		}
		
		return head;
	}	

}
