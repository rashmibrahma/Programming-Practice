package interviewQuestions;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

/*
 * /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */ 
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head){
    	if(head==null || head.next==null){
    		return head;
    	}
    	ListNode fakeHead=new ListNode(0);
    	fakeHead.next=head;
    	ListNode c=head,n=c.next;
    	while(n!=null){
    		if(c.val==n.val){
    			c.next=n.next;
    			n=c.next;
    			continue;
    		}
    		c=n;
    		n=n.next;
    	}
    	return fakeHead.next;
    }
}
