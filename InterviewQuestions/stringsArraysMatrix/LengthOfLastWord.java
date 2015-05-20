package leetCode_easy;

public class LengthOfLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lengthWord("Hello how do you do "));
	}
	
	public static int lengthWord(String text) throws IllegalArgumentException{
		if(text==null){
			throw new IllegalArgumentException();
		}
		if(text.length()==0){
			return 0;
		}
		int i,flag=0;
		for(i=text.length()-1; i>=0; i--){
			if(flag==0 && text.charAt(text.length()-1)==' '){
				flag=1;
				continue;
			}
			if(text.charAt(i)==' '){
				break;
			}
		}
		return text.length()-i-1;
	}

}
