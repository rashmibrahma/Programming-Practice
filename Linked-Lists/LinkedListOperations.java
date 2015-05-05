package linkedLists;

import java.util.ArrayList;

public class LinkedListOperations<A> {
	
	public boolean isPalindrome(SinglyLinkedList<A> head){
		SinglyLinkedList<A> list=new SinglyLinkedList<A>();
		LLNode<A> tempHead=list.head;
		LLNode<A> mid=list.listMid();
		list.head=mid.getNext();
		
		//reverse from this new head
		LLNode<A> secondHead=list.reverseList();
		mid.setNext(secondHead);
		list.head=tempHead;
		return(checkPalindrome(list.head, mid));
	}

	private boolean checkPalindrome(LLNode<A> head, LLNode<A> mid) {
		LLNode<A> afterMid=mid.getNext();
		LLNode<A> beforeMid=head;
		while(beforeMid!=mid){
			if(beforeMid.getData()!=afterMid.getData())
				return false;
			beforeMid=beforeMid.getNext();
			afterMid=afterMid.getNext();
		}
		//check the condition when beforeMid == mid
		if(beforeMid.getData()!=afterMid.getData())
			return false;
		else
			return true;
	}
	
	public SinglyLinkedList<Integer> addLinkedList(int[] numList){
		int numArraySize=numList.length;
		if(numArraySize==0)
			return null;
		
		//convert to linked lists
		ArrayList<SinglyLinkedList<Integer>> lList=convertToLinkedLists(numList);
		
		//find longest list size
		int maxListSize=findMaxListSize(lList, numArraySize);
		
		//pad the short lists with zeroes
		padZeroes(lList,maxListSize,numArraySize);
		
		int sum=0, carry=0;
		SinglyLinkedList<Integer> resultList=new SinglyLinkedList<Integer>();
		while(maxListSize > 0){
			for(int i=0; i<numArraySize; i++){
				carry=lList.get(i).deleteHeadNode()+carry;
			}
			sum=carry%10;
			carry=carry/10;
			resultList.addNode(sum);
			maxListSize--;
		}
		if(carry!=0)
			resultList.addNode(carry);
		return resultList;
		
	}

	private ArrayList<SinglyLinkedList<Integer>> convertToLinkedLists(int[] numList) {
		
		int numArraySize=numList.length;
		
		//creating an arraylist which contains the linkedlist of numbers
		ArrayList<SinglyLinkedList<Integer>> lList=new ArrayList<SinglyLinkedList<Integer>>();

		//convert array of numbers to array of linked lists
		for(int i=0; i<numArraySize; i++){
			SinglyLinkedList<Integer> current=new SinglyLinkedList<Integer>();
			int temp=numList[i];
			do{
				current.addNode(temp%10);
				temp=temp/10;
			}while(temp!=0);
			lList.add(current);
		}
		return lList;
		
	}

	//need to find the longest list in the array of lists so that we can pad the short ones with zeros
	private int findMaxListSize(ArrayList<SinglyLinkedList<Integer>> lList, int numListSize) {
		int maxSize=lList.get(0).listLength();
		for(int i=1; i<numListSize; i++){
			if(maxSize < lList.get(i).listLength()){
				maxSize=lList.get(i).listLength();
			}
		}
		return maxSize;
	}
	
	//pad the short lists with zeroes
	private void padZeroes(ArrayList<SinglyLinkedList<Integer>> lList, int maxListSize, int arraySize){
		for(int i=0; i<arraySize; i++){
			int listSize=lList.get(i).listLength();
			int padLength=(maxListSize-listSize);
			while(padLength > 0){
				lList.get(i).addNode(0);
				padLength--;
			}
		}
	}
}
