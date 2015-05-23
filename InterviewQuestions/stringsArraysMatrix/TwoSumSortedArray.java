package interviewQuestions;

import java.util.Arrays;

public class TwoSumSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums2={0,0,3,4};
    	int[] res2=twoSumSortArr(nums2, 0);
    	System.out.println("\nthe indices: ");
    	for(int i:res2){
    		System.out.println(i);
    	}
	}
	
	  public static int[] twoSumSortArr(int[] nums,int target){
	    	if(nums.length==0){
	    		return null;
	    	}
	    	/*//sort the array first
	    	Arrays.sort(nums);*/
	    	int i=0,j=nums.length-1;
	    	int[] result=new int[2];
	    	while(i<=j){
	    		if(nums[i]+nums[j] == target){
	    			result[0]=i+1;
	    			result[1]=j+1;
	    			break;
	    		}
	    		else if(nums[i]+nums[j] > target){
	    			j--;
	    		}
	    		else if(nums[i]+nums[j] < target){
	    			i++;
	    		}
	    	}
	    	return result;
	    }

}
