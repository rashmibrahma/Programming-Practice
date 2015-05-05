package strings;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharacters {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		try{
			printDuplicates("programming");
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		
		try{
			printDuplicatesHashMap("programming");
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
		catch(NullValue e){
			e.printStackTrace();
		}
	}
	
	/*
	 * using array
	 */
	public static void printDuplicates(String str) throws EmptyString, NullValue{
		
		if(str==null){
			throw new NullValue("Null Value");
		}
		//if string is empty
		if(str.length()==0){
			throw new EmptyString("Empty String");
		}
				
		boolean strArray[]=new boolean[256];
		StringBuffer resultString=new StringBuffer();
		
		str=str.toLowerCase();
		for(int i=0; i<str.length(); i++){
			if(!strArray[str.charAt(i)]){
				strArray[str.charAt(i)]=true;
			}
			else{
				resultString.append(str.charAt(i));
			}
		}
		
		if(resultString.length()==0){
			System.out.println("null");
		}
		
		System.out.println(resultString);
	}

	public static void printDuplicatesHashMap(String str) throws EmptyString, NullValue{
		if(str==null){
			throw new NullValue("null value");
		}
		
		else if(str.length()==0){
			throw new EmptyString("empty string");
		}
		
		char[] word=str.toCharArray();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(Character c:word){
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}
		
		if(map.isEmpty()){
			System.out.println("null");
		}
		
		//printing the duplicates
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue()>1){
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
		}
	}
}
