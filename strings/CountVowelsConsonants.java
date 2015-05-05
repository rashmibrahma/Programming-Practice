package strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountVowelsConsonants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			countVowelsConsonants("hello there");
			countVowelsConsonantsArray("hello there");
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
	}

	private static void countVowelsConsonantsArray(String str) throws NullValue, EmptyString{
		if(str==null){
			throw new NullValue("Null Value");
		}
		//if string is empty
		if(str.length()==0){
			throw new EmptyString("Empty String");
		}
		char c;
		int vowel=0, consonant=0;
		for(int i=0; i<str.length(); i++){
			c=str.toLowerCase().charAt(i);
			if(c==' ')
				continue;
			else if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
				vowel++;
			else
				consonant++;
		}
		
		System.out.println("Vowel: "+vowel);
		System.out.println("Consonant: "+consonant);
	}

	private static void countVowelsConsonants(String str) throws NullValue, EmptyString{
		
		if(str==null){
			throw new NullValue("Null Value");
		}
		//if string is empty
		if(str.length()==0){
			throw new EmptyString("Empty String");
		}
		HashMap<Character, Integer> vowel=new LinkedHashMap<Character, Integer>();
		HashMap<Character, Integer> consonant=new LinkedHashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++){
			char c=str.toLowerCase().charAt(i);
			if(c==' ')
				continue;
			
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
				if(!vowel.containsKey(c))
					vowel.put(c, 1);
				else
					vowel.put(c, vowel.get(c)+1);
			}
			else{
				if(!consonant.containsKey(c))
					consonant.put(c, 1);
				else
					consonant.put(c, consonant.get(c)+1);				
			}
		}	
		
		System.out.println("vowels: ");
		for(Map.Entry<Character, Integer> entry:vowel.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		System.out.println("consonants: ");
		for(Map.Entry<Character, Integer> entry:consonant.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}
	
}
