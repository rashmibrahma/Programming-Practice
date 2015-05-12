package patternSearching;

import java.util.ArrayList;

/*
 * best case: 	txt: AAAAAAAAA --> length of string: n
 * 				pattern: B --> length of string: m
 * 				Complexity: O(n)
 * worst case: 	txt: AAAAAAAAA --> length of string: n
 * 				pattern: AA --> length of string : m
 * 				Complexity: O(m*(n-m+1))	//take note of this!!!
 */
public class NaivePatternSearching {
	public static ArrayList<Integer> search(String pattern, String text) throws EmptyStringException{
		if(text==null){
			throw new EmptyStringException("The text is empty");
		}
		char[] patternArray=pattern.toCharArray();
		char[] textArray=text.toCharArray();
		int patternLength=pattern.length();
		int textLength=text.length();
		ArrayList<Integer> indexList=new ArrayList<Integer>();
		for(int i=0; i<textLength-patternLength; i++){
			int j;
			for(j=0; j<patternLength; j++){
				//check for array index out of bounds
				if(textLength-i < patternLength){
					break;
				}
				if(patternArray[j]!=textArray[i+j]){
					break;
				}
			}
			if(j==patternLength){
				indexList.add(i);
			}
		}
		return indexList;
	}
	public static void main(String[] args){
		try{
			ArrayList<Integer> indexList=search("AAAAA","AAAAAAAAAAAAAAAAAA");
			for(int i:indexList){
				System.out.println("the index is: "+i);
			}
		}
		catch(EmptyStringException e){
			e.printStackTrace();
		}
	}
}
