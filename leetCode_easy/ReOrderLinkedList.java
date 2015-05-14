package leetCode_easy;

/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    
public class ReOrderLinkedList {

	//O(n^2)
	public static void reorderListSlower(ListNode head) {
		if(head==null){
			return;
		}
        ListNode curr=head, front=curr.next;
        ListNode back=findBack(head, null);
        while(front!=null){
        	back=findBack(head, back);
        	curr.next=back.next;
        	back.next=null;
        	if(curr.next!=null){
        		curr.next.next=front;
        	}
        	else{
        		curr.next=front;
        	}
        	curr=front;
        	front=front.next;
        }
        System.out.println();
    }
	
	private static ListNode findBack(ListNode head, ListNode back) {
		ListNode curr=head;
		while(curr.next!=back){
			curr=curr.next;
		}
		//System.out.println("back: "+back.val);
		return curr;
	}

	public static void reorderList(ListNode head){
		if(head==null){
			return;
		}
		//find the mid point of the list
		ListNode mid=findMid(head);
		ListNode curr=head, prev=head;
		curr=revLinkedList(mid);
		System.out.println("rev list:");
		printList(curr);
		
		int length=length(head);
		
		System.out.println();
		while(prev.next!=mid)
		{
			prev=prev.next;			
		}
		prev.next=curr;
		
		printList(head);
		
		ListNode i=head, j=curr, temp1=i.next, temp2=j.next;
		while(temp2.next!=null){
			//System.out.println("\n"+i.val+","+j.val+","+temp1.val+","+temp2.val);
			i.next=j;
			j.next=temp1;
			i=temp1;
			temp1=i.next;
			j=temp2;
			temp2=j.next;
			
		}
		System.out.println("\n"+i.val+","+j.val+","+temp1.val+","+temp2.val+","+prev.val);
		i.next=j;
		j.next=temp1;
		temp1.next=temp2;
		
		if(length%2==1)
		{
			System.out.println(length);
			temp2.next=prev;
			prev.next=null;
		}
		//printList(head);
	}
	
	private static int length(ListNode head) {
		int l=0;
		ListNode temp=head;
		while(temp!=null)
		{
			l++;
			temp=temp.next;
		}
		System.out.println(l);
		return ++l;
	}

	private static ListNode findMid(ListNode head) {
		ListNode slow=head, fast=head, prev=head;
		while(slow!=null){
			prev=slow;	
			if(fast==null || fast.next==null){
				break;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast==null){
			return slow;
		}
		else{
			return slow.next;
		}
	}

	private static ListNode revLinkedList(ListNode head) {
		//ListNode newHead;
		if(head.next==null){
			return head;
		}
		ListNode newHead=revLinkedList(head.next);
		head.next.next=head;
		head.next=null;

		return newHead;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head=makeList(25,head);
		
		ListNode temp=head;
		while(temp!=null){
			System.out.print(temp.val+"-->");
			temp=temp.next;
		}
		
		System.out.println("list: ");
		printList(head);
		System.out.println();
		reorderList(head);
		//temp=revLinkedList(head);
		System.out.println();
		printList(head);
	}
	
	private static void printList(ListNode head) {
		ListNode temp=head;
		while(temp!=null){
			System.out.print(temp.val+"-->");
			temp=temp.next;
		}
	}

	private static ListNode makeList(int n, ListNode head) {
		ListNode temp=head;
		for(int i=head.val+1;i<head.val+n;i++)
		{
			temp.next=new ListNode(i);
			temp=temp.next;
		}
		temp.next=null;
		return head;
	}

}
