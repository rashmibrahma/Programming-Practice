package strings;

public class CheckPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			System.out.println(isPalindrome("madam"));
			System.out.println(isPalindrome("java"));
			System.out.println(isPalindromeReverse("madam"));
			System.out.println(isPalindromeReverse("java"));
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
		
	}
	
	public static boolean isPalindrome(String str) throws NullValue, EmptyString{
		if(str==null)
			throw new NullValue("null string");
		if(str.length()==0)
			throw new EmptyString("String is empty");
		
		int i1=0, i2=str.length()-1;
		while(i1<=i2){
			if(str.charAt(i1)!=str.charAt(i2))
				return false;
			i1++;
			i2--;
		}
		return true;
	}
	
	public static boolean isPalindromeReverse(String str) throws NullValue, EmptyString{
		if(str==null)
			throw new NullValue("null string");
		if(str.length()==0)
			throw new EmptyString("String is empty");
		
		StringBuilder temp=new StringBuilder(str);
		return str.equals(temp.reverse().toString());
	}

}
