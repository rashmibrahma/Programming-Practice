package leetCode_easy;
/*
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListNode {

	public ListNode removeElements(ListNode head, int val){
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
	

}
