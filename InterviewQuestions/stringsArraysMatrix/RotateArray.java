package stringsArraysMatrix;
/*
 * You may have been using Java for a while. 
 * Do you think a simple Java array question can be a challenge? 
 * Let's use the following problem to test.

Problem: Rotate an array of n elements to the right by k steps. 
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
How many different ways do you know to solve this problem?
 */

public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums={1,2,3,4,5,6,7};
		System.out.println("original array for naive method: ");
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		rotateNaive(nums,3);
		System.out.println("original array for reverse method: ");
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		rotateReverse(nums,3);
	}

	//time complexity: O(n*k)
	public static void rotateNaive(int[] nums, int k){
		if(k==0 || k==nums.length){
			return;
		}
		while(k>0){
			shiftElements(nums,nums[nums.length-1]);
			k--;
		}
		System.out.println("naive method: ");
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	
	private static void shiftElements(int[] nums, int temp) {
		for(int i=nums.length-1;i>0; i--){
			nums[i]=nums[i-1];
		}
		nums[0]=temp;
	}
	
	//time complexity: O(n)
	private static void rotateReverse(int[] nums, int k) {
		if(k==0 || k==nums.length){
			return;
		}
		reverse(nums,0,nums.length-k-1);
		reverse(nums,nums.length-k,nums.length-1);
		reverse(nums,0,nums.length-1);
		System.out.println("reverse method: ");
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
	}

	private static void reverse(int[] nums, int start, int end) {
		
		for(int i=start, j=end; i<=j; i++,j--){
			int last=nums[j];
			int first=nums[i];
			int temp=first;
			nums[i]=last;
			nums[j]=temp;
		}
	}
}

