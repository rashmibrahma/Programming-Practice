package stack;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printStack();
		System.out.println("pop: "+stack.pop());
		System.out.println("Top: "+stack.top.getData());
		stack.printStack();
		stack.push(5);
		stack.printStack();
		System.out.println("peek: "+stack.peek());

		System.out.println("Top: "+stack.top.getData());
		stack.printStack();

	}

}
