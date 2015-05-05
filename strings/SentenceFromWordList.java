package strings;

import java.util.ArrayList;

/*
 * Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion?

Example:

Input: {{"you", "we"},
        {"have", "are"},
        {"sleep", "eat", "drink"}}

Output:
  you have sleep
  you have eat
  you have drink
  you are sleep
  you are eat
  you are drink
  we have sleep
  we have eat
  we have drink
  we are sleep
  we are eat
  we are drink 
 */
public class SentenceFromWordList {
	
	/*
	 * without using recursion, you will have to implement three loops and take in the values one at a time
	 */

	public static void main(String[] args){
		String arr[][]  = {{"you", "we",""},
                {"have", "are",""},
                {"sleep", "eat", "drink"}};
		
		print(arr);
	}
	
	private static void print(String[][] arr){
		String[] output=new String[3];
		
		for(int i=0; i<arr[0].length; i++){
			if(arr[0][i]!="")
				printUtil(arr, 0, i, output);
		}
	}

	private static void printUtil(String[][] arr, int m, int n, String[] output) {
		
		output[m]=arr[m][n];
		
		//print the sentence if you have reached the end of the list
		if(m==arr.length-1){
			for(int i=0; i<output.length; i++){
				System.out.print(output[i]+"\t");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr[0].length; i++){
			if(arr[m+1][i]!=""){
				printUtil(arr, m+1, i, output);
			}
		}
	}
}
