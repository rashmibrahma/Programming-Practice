package leetCode_easy;

public class SieveOfEratosthenes {

	public static int countPrimesSieveEratosthenes(int n){
		if(n<2){
			return 0;
		}
		int count=0;
		//initialize an array to do sieve of eratosthenes
		boolean[] primes=new boolean[n];
		for(int i=2; i<n; i++){
			primes[i]=true;
		}
		for(int i=2; i<n; i++){
			if(primes[i]){
				for(int j=i+i; j<n; j=j+i){
					primes[j]=false;
				}
			}
		}
		for(int i=2; i<n; i++){
			if(primes[i]){
				//System.out.println(i);
				count++;
			}
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countPrimesSieveEratosthenes(10));
		System.out.println(countPrimesSieveEratosthenes(499979));
	}

}
