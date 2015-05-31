package leetCode_easy;
import java.util.HashMap;
/*
 *  Given an array of integers and an integer k, find out whether there there are two distinct 
 *  indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
 */
public class ContainsDuplicateII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums={1,2,2,1,6,5,1,4,5};
		int k=1;
		System.out.println(containsNearbyDuplicate(nums, k));
	}
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
/*        for(int i=0;i<nums.length;i++){
        	for(int j=0;j<nums.length;j++){
        		if(i!=j && nums[i]==nums[j] && Math.abs(i-j)<=k){
        			return true;
        		}
        	}
        }
        return false;*/
    	if(nums==null||nums.length==0){
    		return false;
    	}
    	HashMap<Integer,Integer> numsMap=new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(!numsMap.containsKey(nums[i])){
    			numsMap.put(nums[i], i);
    		}
    		else{
    			int temp=numsMap.get(nums[i]);
    			if(Math.abs(temp-i) <= k){
    				return true;
    			}
    			numsMap.put(nums[i], i);
    		}
    	}
    	return false;
    }

}
