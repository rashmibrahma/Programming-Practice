package queue;

public class QueueTesterClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Queue<String> lList = new Queue<String>();
		lList.enQueue("1");
		lList.enQueue("2");
		lList.enQueue("3");
		lList.enQueue("4");
		lList.enQueue("5");
		lList.printQueue();
		System.out.println(lList.deQueue());
		System.out.println(lList.deQueue());
		lList.enQueue("8");
		System.out.println(lList.head.getData());
		System.out.println(lList.head.getNext().getData());
		lList.printQueue();
        /*System.out.println("lList dequeue: " + lList.deQueue());
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList dequeue: " + lList.deQueue());
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("Queue empty? "+lList.isEmpty());*/
        lList.deQueue();
        lList.deQueue();
        System.out.println("*********************");
        System.out.println("Queue empty? "+lList.isEmpty());
        lList.deQueue();
        System.out.println("Queue empty? "+lList.isEmpty());
        lList.deQueue();
        
	}

}
