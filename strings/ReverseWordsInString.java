package strings;

import java.util.Stack;

public class ReverseWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverseWordsInStringDS("Java Programming at its best"));
		System.out.println(reverseWordsInStringInPLace("Java Programming at its best"));
	}

	private static String reverseWordsInStringInPLace(String str) {
		StringBuilder reverseStr=new StringBuilder(str);
		reverseStr=reverseStr.reverse();
		String[] revArray=reverseStr.toString().split(" ");
		StringBuilder resultString=new StringBuilder();
		
		for(String s:revArray){
			StringBuilder temp=new StringBuilder(s);
			resultString.append(temp.reverse());
			if(!s.equals(revArray[revArray.length-1]))
				resultString.append(" ");
		}
		
		return resultString.toString();
		
	}

	private static String reverseWordsInStringDS(String str) {
		Stack<String> stack=new Stack<String>();
		String[] strArray=str.split(" ");
		for(String s:strArray){
			stack.push(s);
			if(!s.equals(strArray[strArray.length-1]))
				stack.push(" ");
		}
		StringBuilder resString=new StringBuilder();
		while(!stack.isEmpty()){
			resString.append(stack.pop());
		}
		
		return resString.toString();
	}

}
