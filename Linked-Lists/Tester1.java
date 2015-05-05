package linkedLists;

public class Tester1 {
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> l=new SinglyLinkedList<Integer>();
		l.addNode(1);
		l.addNode(2);
		l.addNode(3);
		l.printList();
		System.out.println("mid"+l.listMid());
		System.out.println(l.listSize());
		l.addHeadNode(0);
		l.printList();
		System.out.println("mid"+l.listMid());
		System.out.println(l.listSize());
		l.addNode(1, 2);
		l.printList();
		System.out.println("mid"+l.listMid());
		l.deleteNode(3);
		l.printList();
		System.out.println("mid"+l.listMid());
		l.deleteHeadNode();
		l.printList();
		System.out.println("mid"+l.listMid());
		System.out.println(l.listSize());
		System.out.println("************************");
		System.out.println(l.nthNodeFromEndOfLinkedList(2).getData());
		/////////////////////////////////////////////////////////////////
		
		/*SinglyLinkedList<Integer> l1=new SinglyLinkedList<Integer>();
		l1.addNode(1);
		l1.addNode(2);
		l1.addNode(3);
		l1.addNode(4);
		l1.printList();
		System.out.println("mid"+l1.listMid().getData());
		l1.addNode(5);
		l1.printList();
		System.out.println("mid"+l1.listMid().getData());
		System.out.println(l1.reverseList().getData());
		l1.reverseList();
		l1.printList();
		l1.reverseList();
		l1.printList();
		
		System.out.println("***********************************");
		l1.deleteList();
		l1.addNode(1);
		l1.addNode(3);
		l1.addNode(2);
		l1.addNode(1);
		//l1.addNode(1);
		//l1.addNode(4);
		l1.printList();
		
		//checking palindrome will affect the original linked list
		System.out.println(l1.isPalindrome());
		
		l1.printList();
		SinglyLinkedList<Integer> l2=new SinglyLinkedList<Integer>();
		System.out.println("list2"+l2.isPalindrome());
		System.out.println(l1.isPalindrome());
		
		System.out.println("Delete list1");
		l1.deleteList();
		l1.printList();
		
		//adding linked lists
		System.out.println("@#$$$$$$$$$$$$$$$$$$$%^&*()*&^%$#@!#$%^&*()*&^%$#@!#$%^&");
		LinkedListOperations<Integer> l11=new LinkedListOperations<Integer>();
		int[] numList=new int[]{234,993,1};
		l11.addLinkedList(numList).printList();*/
	}
	
	
	
}
