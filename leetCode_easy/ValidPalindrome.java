package leetCode_easy;

public class ValidPalindrome {
	
	public static boolean isPalindrom(String s){
		s=s.toLowerCase().replaceAll("[^A-Za-z0-9]*", "");
		int i=0, j=s.length()-1;
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrom("Malayalam"));
		System.out.println(isPalindrom("maam"));
		System.out.println(isPalindrom("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrom("hello"));
	}

}
