package queue;

public class Node<A> {
	/*defining the linked list using nodes and edges. Nodes contain the data 
	and the pointer to the next node.*/ 
	A data;	//data can be of any object type
	Node<A> next;
	
	public Node(A dataValue){
		data = dataValue;
		next = null;
	}
	
	public Node(A dataValue, Node<A> nextValue){
		data = dataValue;
		next = nextValue;
	}
	
	//method to get the value from the node
	public A getData(){
		return data;
	}
	
	//method to set the value of data
	public void setData(A dataValue){
		data = dataValue;
	}
	
	//method to get the next pointer to node
	public Node<A> getNext(){
		return next;
	}
	
	//method to set the next pointer value to
	public void setNext(Node<A> nextValue){
		next = nextValue;
	}
}
