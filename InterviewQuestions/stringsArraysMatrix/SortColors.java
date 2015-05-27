package interviewQuestions;

public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] colors={1,2,0,0,2,1};
		sortColors(colors);
	}
	
	public static void sortColors(int[] nums){
		if(nums==null){
			throw new IllegalArgumentException();
		}
		if(nums.length==1){
			return;
		}
		int zero=0,one=0,two=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				zero++;
			}
			else if(nums[i]==1){
				one++;
			}
			else if(nums[i]==2){
				two++;
			}
		}
		int i;
		for(i=0;i<zero;i++){
			nums[i]=0;
		}
		int j;
		for(j=i;j<one+i;j++){
			nums[j]=1;
		}
		for(int k=j;k<two+j;k++){
			nums[k]=2;
		}
		for(int m=0;m<nums.length;m++){
			System.out.print(nums[m]+"\t");
		}
	}

}
