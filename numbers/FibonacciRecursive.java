package numbers;

public class FibonacciRecursive {

	public static void main(String[] args) {
		for(int i=0; i<=10; i++){
			System.out.print(recursiveFibonacciFn(i)+"\t");
		}
	}
	private static int recursiveFibonacciFn(int num) {
		if(num<=1){
			return num;
		}
		return(recursiveFibonacciFn(num-1) + recursiveFibonacciFn(num-2));
	}
}
