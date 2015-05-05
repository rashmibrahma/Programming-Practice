package strings;

public class ReverseString {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		try{
			System.out.println(reverseIterative("string"));
			//System.out.println(reverseRecursive("string"));
			
			System.out.println(new StringBuilder("hello there").reverse().toString());
			System.out.println(reverseRecursively("Hello there"));
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
	}

	private static String reverseRecursive(String str) throws NullValue, EmptyString{
		StringBuffer strBuffer=new StringBuffer();
		int counter=0;
		
		return reverseRecursive(str, strBuffer, counter);
	}

	private static String reverseRecursive(String str, StringBuffer strBuffer, int counter) {
		//base case
		if(str.length()<2){
			return str;
		}
		
		strBuffer.append(str.charAt(str.length()-counter));
		reverseRecursive(str.substring(counter, str.length()-counter), strBuffer, counter++);
		
		return strBuffer.toString();
		
	}
	
	public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }



	private static String reverseIterative(String str) throws NullValue, EmptyString {
		if(str==null)
			throw new NullValue("null value");
		else if(str.length()==0)
			throw new EmptyString("empty string");
		
		StringBuffer reversedString=new StringBuffer();
		for(int i=str.length()-1; i>-1; i--){
			reversedString.append(str.charAt(i));
		}
		return reversedString.toString();
	}

}
