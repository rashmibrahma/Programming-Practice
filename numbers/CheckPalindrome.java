package numbers;

public class CheckPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(1234));
		System.out.println(isPalindrome(13431));
		System.out.println(isPalindrome(-2));
	}
	
	private static boolean isPalindrome(int number){
		try{
			return (number == reverse(number));
		}
		catch(Exception e){
			if(e instanceof IllegalArgumentException){
				return false;
			}
			else{
				e.printStackTrace();
			}
		}
		return false;
	}

	private static int reverse(int number) throws Exception{
		if(2*number < number){
			throw new IllegalArgumentException();
		}
		int reverseNumber=0;
		while(number!=0){
			 reverseNumber=reverseNumber*10 + number%10;
			 number=number/10;
		}
		return reverseNumber;
	}

}
