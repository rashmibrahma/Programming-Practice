package interviewQuestions;

public class LongestPalindromeSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLongestPalindromeNaive("Bob speaks malayalam"));
		System.out.println(findLongestPalindromeNaive("malayalamaaaaaaaaaaaaaaaaaaaaaabob"));
	}
	
	//O(n^3) : naive method!!!
	private static String findLongestPalindromeNaive(String str){
		str=str.replaceAll("\\s", "").toLowerCase();
		int len=str.length();
		String result="";
		for(int i=0; i<len; i++){
			for(int j=len-1; j>=0; j--){
				if(isPalindrome(str,i,j)){
					String subStr=str.substring(i, j+1);
					if(subStr.length()>result.length()){
						result=subStr;
					}
					i=j;
					break;
				}
				else{
					continue;
				}
			}
		}
		return result;
	}

	private static boolean isPalindrome(String str, int i_index, int j_index) {
		while(i_index<=j_index){
			if(str.charAt(i_index)!=str.charAt(j_index)){
				return false;
			}
			else{
				i_index++;
				j_index--;
			}
		}
		return true;
	}

}
