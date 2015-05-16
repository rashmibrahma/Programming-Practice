/*The problem:

You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * 
 */

package interviewQuestions;

public class AddLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node l1=new Node(2);
		l1.next=new Node(4);
		l1.next.next=new Node(3);
		System.out.println();
		printList(l1);
		System.out.println();
		
		Node l2=new Node(5);
		l2.next=new Node(6);
		l2.next.next=new Node(4);
		System.out.println();
		printList(l2);
		System.out.println();
		
		Node l3=addTwoNumbers(l1,l2);
		System.out.println();
		printList(l3);
	}

	private static void printList(Node l) {
		Node c=l;
		while(c!=null){
			if(c.next!=null){
				System.out.print(c.x+"-->");	
			}
			else{
				System.out.print(c.x);
			}
			c=c.next;
		}
	}

	private static Node addTwoNumbers(Node l1, Node l2) {
		if(l1==null && l2==null){
			return new Node(0);
		}
		if(l1==null){
			return l2;
		}
		else if(l2==null){
			return l1;
		}
		int sum=0, carry=0;
		Node c1=l1, c2=l2, l3=new Node(0), c3=l3;
		while(c1!=null && c2!=null){
			sum=c1.x+c2.x+carry;
			carry=sum/10;
			sum=sum%10;
			c3.next=new Node(sum);
			c3=c3.next;
			c1=c1.next;
			c2=c2.next;
		}
		if(c1!=null){
			c3.next=c1;
		}
		else if(c2!=null){
			c3.next=c2;
		}
		l3=l3.next;
		return l3;
	}

}
