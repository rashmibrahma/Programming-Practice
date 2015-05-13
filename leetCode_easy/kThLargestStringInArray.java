package leetCode_easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kThLargestStringInArray {
	public static String findString(List<String> list, int k) throws EmptyListException{
		if(list==null){
			throw new EmptyListException("List is empty");
		}
		HashMap<Integer, String> strLen=new HashMap<Integer, String>();
		int len;
		for(String word:list){
			len=word.length();
			strLen.put(len, word);
		}
		List<Integer> keyList=new ArrayList<Integer>();
		for(Map.Entry<Integer, String> entry: strLen.entrySet()){
			keyList.add(entry.getKey());
		}
		Collections.sort(keyList);
		int max=keyList.get(keyList.size()-1);
		int count=1;
		for(int i=keyList.size()-2; count!=k && i>=0; i--){
			if(max==keyList.get(i)){
				continue;
			}
			else{
				max=keyList.get(i);
				count++;
			}
		}
		return strLen.get(max);		
	}
	
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		list.add("Hello");
		list.add("expo");
		list.add("conforms");
		list.add("hi");
		list.add("aloha");
		list.add("babies");
		try{
			System.out.println(findString(list, 3));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
