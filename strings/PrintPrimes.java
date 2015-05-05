package strings;

public class PrintPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			printPrimes(20);
		}
		catch(NullValue e){
			e.printStackTrace();
		}
	}

	private static void printPrimes(int num) throws NullValue{
		for(int i=2; i<=num; i++){
			if(isPrime(i))
				System.out.println(i);
		}
	}

	private static boolean isPrime(int num) {
		for(int i=2; i<	num; i++){
			if(num%i==0)
				return false;
		}
		return true;
	}

}
