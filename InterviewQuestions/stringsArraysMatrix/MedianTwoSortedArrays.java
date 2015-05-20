package interviewQuestions;

import java.util.Arrays;

public class MedianTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a={1,12,15,26};
		int[] b={2,13,17,30};
		System.out.println(findMedianSortedArrays(a, b));
	}
	
	public static int findMedianSortedArrays(int[] a,int[] b){
		if(a==null){
			return findMedian(b);
		}
		else if(b==null){
			return findMedian(a);
		}
		if(a.length!=b.length){
			return 0;
		}
		if(a.length==2){
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1]))/2;
		}
		int medianA=findMedian(a);
		int medianB=findMedian(b);
		if(medianA<medianB){
			if(a.length%2==0){
				return findMedianSortedArrays(Arrays.copyOfRange(a, (a.length/2)-1, a.length), Arrays.copyOfRange(b, 0, (b.length/2)+1));
			}
			else{
				return findMedianSortedArrays(Arrays.copyOfRange(a, a.length/2, a.length),Arrays.copyOfRange(b, 0, b.length/2+1));
			}
		}
		else{
			if(a.length%2==0){
				return findMedianSortedArrays(Arrays.copyOfRange(a, 0, (a.length/2)-1), Arrays.copyOfRange(b, 0, (b.length/2)+1));
			}
			else{
				return findMedianSortedArrays(Arrays.copyOfRange(a, 0, (a.length/2)+1), Arrays.copyOfRange(b, b.length/2, b.length));
			}
		}
	}
	
	private static int findMedian(int[] n){
		int len=n.length;
		if(len%2==0){
			int p=(len/2)-1;
			int q=len/2;
			return (n[p]+n[q])/2;
		}
		else{
			return n[len/2];
		}
	}

}
