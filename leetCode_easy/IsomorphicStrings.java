package leetCode_easy;

import java.util.HashMap;

public class IsomorphicStrings {

	/*
	 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

	 */
	
	public static boolean isIsomorphic(String inputStr1, String inputStr2){
		if(inputStr1.length()!=inputStr2.length()){
			return false;
		}
		if(inputStr1.length()==1){
			return true;
		}
		HashMap<Character, Character> charMap=new HashMap<Character, Character>();		
		int length1=inputStr1.length();
		for(int i=0; i<length1; i++){
			if(!charMap.containsKey(inputStr1.charAt(i))){
				if(charMap.containsValue(inputStr2.charAt(i))){
					return false;
				}
				else{
					charMap.put(inputStr1.charAt(i), inputStr2.charAt(i));
				}
			}
			if(!charMap.get(inputStr1.charAt(i)).equals(inputStr2.charAt(i))){
				return false;
			}
		}
		return true;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("bar", "foo"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("ab", "aa"));
		System.out.println(isIsomorphic("aa", "ab"));
		System.out.println(isIsomorphic("ab", "ab"));
	}

}
