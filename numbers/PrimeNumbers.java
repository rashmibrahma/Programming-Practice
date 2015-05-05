package numbers;

public class PrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printAllPrimes(20);
	}

	private static void printAllPrimes(int number) {
		if(number<2){
			return;
		}
		for(int i=2; i<=number; i++){
			if(isPrime(i)){
				System.out.print(i+"\t");
			}
		}
	}

	private static boolean isPrime(int number) {
		for(int i=2; i<number; i++){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}

}
