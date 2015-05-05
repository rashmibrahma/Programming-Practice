package queueUsingStack;

public class QueueTesterClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		QueueUsingStackRec<String> lList = new QueueUsingStackRec<String>();
		lList.enQueue("1");
		lList.enQueue("2");
		lList.enQueue("3");
		lList.enQueue("4");
		lList.enQueue("5");
		lList.printQueue();
		System.out.println(lList.deQueue());
		
		System.out.println(lList.deQueue());
		lList.enQueue("8");
		lList.printQueue();
		lList.deQueue();
		lList.deQueue();
		lList.printQueue();


	}

}
