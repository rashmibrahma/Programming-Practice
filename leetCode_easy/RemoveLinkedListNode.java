package leetCode_easy;
/*
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListNode {

	public static ListNode removeElements(ListNode head, int val){
		if(head==null){
			return null;
		}
		ListNode helperHead=new ListNode(0);
		helperHead.next=head;
		ListNode current=helperHead;
		while(current!=null){
			if(current.next!=null && current.next.val==val){
				current.next=current.next.next;
			}
			else{
				current=current.next;
			}
		}
		return helperHead.next;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(6);
		head.next.next.next=new ListNode(3);
		head.next.next.next.next=new ListNode(4);
		head.next.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next.next=new ListNode(6);
		head.next.next.next.next.next.next.next=null;
		ListNode current=head;
		while(current!=null){
			System.out.print(current.val+"-->");
			current=current.next;
		}
		current=removeElements(head, 6);
		System.out.println();
		while(current!=null){
			System.out.print(current.val+"-->");
			current=current.next;
		}
		ListNode head1=new ListNode(1);
		//head1.next=null;
		/*ListNode current=head1;
		while(current!=null){
			System.out.print(current.val+"-->");
			current=current.next;
		}
		current=removeElements(head1, 1);
		System.out.println();
		while(current!=null){
			System.out.print(current.val+"-->");
			current=current.next;
		}*/
	}

}
