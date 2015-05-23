package interviewQuestions;

import java.util.HashMap;
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

For example:

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {
	//O(n^2)
    public static int[] twoSumBruteForce(int[] nums, int target) {
    	if(nums.length==0 || target==0){
    		return null;
    	}
    	int[] result=new int[2];
    	for(int i=0;i<nums.length; i++){
    		for(int j=i+1;j<nums.length;j++){
    			if(nums[i]+nums[j]==target){
    				result[0]=i+1;
    				result[1]=j+1;
    			}
    		}
    	}
    	return result;
    }
    
    //O(n) --> just find the complement of the number
    public static int[] twoSumHashMap(int[] nums,int target){
    	if(nums.length==0 || target==0){
    		return null;
    	}
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int[] result=new int[2]	;
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			int index=map.get(nums[i]);
    			result[0]=index+1;
    			result[1]=i+1;
    		}
    		else{
    			map.put(target-nums[i], i);
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	int[] nums={1,2,5,7,11,15};
    	int target=9;
    	int[] res=twoSumBruteForce(nums, target);
    	System.out.println("the array of numbers: ");
    	for(int i:nums){
    		System.out.print(i+" ");
    	}
    	System.out.println("\nthe indices: ");
    	for(int i:res){
    		System.out.println(i);
    	}
    	
    	int[] res1=twoSumBruteForce(nums, target);
    	System.out.println("\nthe indices: ");
    	for(int i:res1){
    		System.out.println(i);
    	}
    }
}
