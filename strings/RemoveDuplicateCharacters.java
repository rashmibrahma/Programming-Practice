package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicateCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(removeDuplicateCharacters("bananas"));
		System.out.println(removeDuplicateCharacters("proGramming"));
	}

	private static String removeDuplicateCharacters(String str) {
		HashSet<Character> map=new LinkedHashSet<Character>();
		for(int i=0; i<str.length(); i++){
			if(!map.contains(str.charAt(i)))
				map.add(str.charAt(i));
		}
		
		StringBuilder res=new StringBuilder();
		for(Character it:map){
			res.append(it);
		}
		
		return res.toString();
	}

}
