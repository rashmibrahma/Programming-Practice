package interviewQuestions;
import java.util.HashMap;
import java.util.Stack;
/*
 * Problem:

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" 
are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isValid("({[]})"));
		System.out.println(isValid("{(})"));
	}
	
	public static boolean isValid(String patt){
		if(patt==null){
			return false;
		}
		HashMap<Character,Character> map=new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<patt.length();i++){
			Character curr=patt.charAt(i);
			if(map.containsKey(curr)){
				s.push(curr);
			}
			else if(map.values().contains(curr)){
				if(!s.isEmpty() && map.get(s.peek())==curr){
					s.pop();
				}
				else{
					return false;
				}
			}
		}
		return true;
	}

}
