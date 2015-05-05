package numbers;

public class ArmstrongNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isArmstrong(123));
		System.out.println(isArmstrong(371));
	}
	
	private static boolean isArmstrong(int number){
		if(number < 0){
			return false;
		}
		int cubeSum=0, numberCopy=number;
		while(number!=0){
			cubeSum=(int) (cubeSum+Math.pow(number%10, 3));
			number=number/10;
		}
		return (cubeSum==numberCopy);
	}

}
