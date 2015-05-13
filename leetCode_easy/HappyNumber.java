package leetCode_easy;

import java.util.HashSet;

public class HappyNumber {
/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

 */
	public static boolean isHappy(int n){
		if(n==1){
			return true;
		}
		HashSet<Integer> happySet=new HashSet<Integer>();
		while(n!=1){
			int temp=n, sum=0;
			while(temp!=0){
				sum=sum+(int) Math.pow(temp%10, 2);
				temp=temp/10;
			}
			/*if(sum==1){
				return true;
			}*/
			if(!happySet.contains(sum)){
				happySet.add(sum);
				n=sum;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(145));
	}

}
