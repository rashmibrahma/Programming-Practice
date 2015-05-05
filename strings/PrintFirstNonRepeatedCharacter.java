package strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class PrintFirstNonRepeatedCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			System.out.println(printHash("Morning"));
			System.out.println(printArray("Morning"));
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
	}

	private static char printArray(String str) throws NullValue, EmptyString {
		if(str==null)
			throw new NullValue("String is null");
		
		if(str.length()==0)
			throw new EmptyString("String is empty");
		
		char[] strArray=str.toLowerCase().toCharArray();
		HashMap<Character, Integer> repeats=new HashMap<Character, Integer>();
		LinkedList<Character> nonRepeats=new LinkedList<Character>();
		for(Character c:strArray){
			if(!repeats.containsKey(c)){
				repeats.put(c, 1);
				nonRepeats.add(c);
			}
			else{
				repeats.put(c, repeats.get(c)+1);
				nonRepeats.remove(c);
			}
		}
		return nonRepeats.element();
			
	}

	private static char printHash(String str) throws NullValue, EmptyString{
		if(str==null)
			throw new NullValue("String is null");
		
		if(str.length()==0)
			throw new EmptyString("String is empty");
		
		char[] strArr=str.toLowerCase().toCharArray();
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		for(Character c:strArr){
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue()==1){
				return entry.getKey();
			}				
		}
		return (Character) null;
	}

}
