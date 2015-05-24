package interviewQuestions;

/*public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
*/

public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head){
		if(head.next==null){
			return head;
		}
		ListNode newHead=reverseLinkedList(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}

}
