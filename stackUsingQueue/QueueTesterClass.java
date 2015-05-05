package stackUsingQueue;

public class QueueTesterClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StackUsingQueue<String> lList = new StackUsingQueue<String>();
		lList.push("1");
		lList.push("2");
		lList.push("3");
		lList.push("4");
		lList.push("5");
		lList.printQueue();
		System.out.println(lList.pop());
		System.out.println(lList.pop());
		lList.push("8");
		//System.out.println(lList.getData());
		//System.out.println(lList.head.getNext().getData());
		lList.printQueue();
		/*System.out.println("lList dequeue: " + lList.deQueue());
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList dequeue: " + lList.deQueue());
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("Queue empty? "+lList.isEmpty());*/
		lList.pop();
		lList.pop();
		System.out.println("*********************");
		lList.printQueue();


	}

}
