package interviewQuestions;

public class LinkedListCycle {

	public boolean hasCycle(Node head){
		if(head==null){
			throw new IllegalArgumentException();
		}
		Node slow=head,fast=head;
		while(slow!=null){
			if(fast==null||fast.next==null){
				break;
			}
			if(fast==slow){
				return true;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		return false;
	}

}
