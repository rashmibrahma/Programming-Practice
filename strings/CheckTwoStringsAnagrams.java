package strings;

import java.util.HashMap;
import java.util.Map;

public class CheckTwoStringsAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			System.out.println(isAnagram("Army", "Mary"));
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		
		System.out.println(checkAnagram("army", "mary"));
	}

	private static boolean isAnagram(String str1, String str2) throws NullValue{
	
		//check for null
		if(str1==null || str2==null){
			throw new NullValue("one or both of the strings has a null value");
		}
		
		//check unequal lengths
		if(str1.length()!=str2.length()){
			return false;
		}
		
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		char[] str1Arr=str1.toCharArray();
		char[] str2Arr=str2.toCharArray();
		
		for(Character c:str1Arr){
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}
		
		for(Character c:str2Arr){
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)-1);
		}
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue()>0)
				return false;
		}
		return true;
		
	}

	public static boolean checkAnagram(String first, String second){
		char[] characters = first.toCharArray();
		StringBuilder sbSecond = new StringBuilder(second);

		for(char ch : characters){
			int index = sbSecond.indexOf("" +ch);
			if(index != -1){
				sbSecond.deleteCharAt(index);
			}else{
				return false;
			}
		}

		return sbSecond.length()==0 ? true : false;
	}



}
