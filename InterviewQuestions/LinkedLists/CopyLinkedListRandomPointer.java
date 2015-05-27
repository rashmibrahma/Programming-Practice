package interviewQuestions;
import java.util.HashMap;

/*
 * public class RandomListNode {
	int label;
	RandomListNode next, random;
	public RandomListNode(int x) { this.label = x; }
}
 */

public class CopyLinkedListRandomPointer {

	public static RandomListNode copyList(RandomListNode head){
		if(head==null){
			return null;
		}
		RandomListNode p=head;
		HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
		RandomListNode copyHead=new RandomListNode(p.label);
		RandomListNode q=copyHead;
		map.put(p, q);
		p=p.next;
		while(p!=null){
			RandomListNode temp=new RandomListNode(p.label);
			map.put(p, temp);
			q.next=temp;
			p=p.next;
		}
		p=head;q=copyHead;
		while(p!=null){
			if(p.random!=null){
				q.random=map.get(p.random);
			}
			else{
				q.random=null;
			}
			p=p.next;
			q=q.next;
		}
		
		return copyHead;
	}
	
}
