package numbers;

/*
 * Programming question based on numbers
 * http://javarevisited.blogspot.com/2011/06/top-programming-interview-questions.html
 */

public class PowerOfTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(5));
		System.out.println(isPowerOfTwo(1024));
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(-16));
	}

	private static boolean isPowerOfTwo(int num) {
		try{
			if(num==1){
				return false;
			}
			if((num & (num-1)) == 0){
				return true;
			}
			
		}
		catch(Exception e){
			if(e instanceof IllegalArgumentException){
				return false;
			}
		}
		return false;
	}

}
