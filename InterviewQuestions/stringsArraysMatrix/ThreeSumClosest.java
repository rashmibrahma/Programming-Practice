package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution. 
 * For example, given array S = {-1 2 1 -4}, and target = 1. 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	
	public static void main(String[] args){
		int[] nums={0,1,2};
		int target=0;
		System.out.println(threeSumClosest(nums, target));
	}
	
	public static ArrayList<Integer> threeSumClosest(int[] nums,int target){
		if(nums.length<3){
			return 0;
		}
		Arrays.sort(nums);
		int diff=Integer.MAX_VALUE;
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<nums.length-2;i++){
			int start=i+1;
			int end=nums.length-1;
			while(start<end){
				int sum=nums[i]+nums[start]+nums[end];
				if(sum == target){
					result=new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[start]);
					result.add(nums[end]);
					return result;
					//return sum;
				}
				else if(sum < target){
					if(Math.abs(target-sum) < diff){
						diff=Math.abs(target-sum);
						result=new ArrayList<Integer>();
						result.add(nums[i]);
						result.add(nums[start]);
						result.add(nums[end]);
					}					
					start++;
				}
				else{
					if(Math.abs(target-sum) < diff){
						diff=Math.abs(target-sum);
						result=new ArrayList<Integer>();
						result.add(nums[i]);
						result.add(nums[start]);
						result.add(nums[end]);
					}
					end--;
				}
			}
		}
		return result;
		/*int sum=0;
		for(int i:result){
			sum+=i;
		}
		return sum;*/
	}
}
