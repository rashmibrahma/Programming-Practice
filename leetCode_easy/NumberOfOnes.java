package leetCode_easy;

public class NumberOfOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hammingWeight(8));
	}
	
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        if(n==0){
        	return 0;
        }
        int count=0;
        for(int i=1; i<=32; i++){
        	if((n&1) == 1){
        		count++;
        	}
        	n=n>>1;
        }
        return count;
    }

}
