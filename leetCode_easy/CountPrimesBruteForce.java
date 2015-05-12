package leetCode_easy;

/*
 * Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrimesBruteForce {

	//this code is extremely slow!!! (countPrimes(499979));--> more than 30 secs
    public static int countPrimes(int n) {
        if(n==1){
        	return 0;
        }
        int count=0;
        while(n>1){
        	if(isPrime(n)){
        		count++;
        	}
        	n--;
        }
        return count;
    }	
	private static boolean isPrime(int n) {
		for(int i=2; i<n; i++){
			if(n!=i && n%i==0){
				return false;
			}
		}
		return true;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countPrimes(2));
		System.out.println(countPrimes(5));
		System.out.println(countPrimes(10));
		System.out.println(countPrimes(499979));
		//System.out.println(countPrimes(499979));
	}

}
