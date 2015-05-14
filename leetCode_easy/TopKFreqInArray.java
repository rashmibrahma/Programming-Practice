package leetCode_easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/*
 * find the top k frequency in an array
 * [1,2,3,1,2,3,4,4,5,4,4]; k=3: return[4,2,1], [4,1,3], [4,2,3]
 * [1,1,1,2,2,3,4]; k=2: return [1,2]
 */
public class TopKFreqInArray {

	public static ArrayList<Integer> searchFreqList(ArrayList<Integer> list) throws EmptyListException{
		if(list==null){
			throw new EmptyListException("List is empty");
		}
		HashMap<Integer, Integer> freqMap=new HashMap<Integer, Integer>();
		for(Integer num: list){
			if(!freqMap.containsKey(num)){
				freqMap.put(num, 1);
			}
			else{
				freqMap.put(num, freqMap.get(num)+1);
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
