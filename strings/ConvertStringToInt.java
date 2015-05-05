package strings;

public class ConvertStringToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1=convertStringToInt("543");
		int num2=convertStringToInt("543");
		System.out.println(num1+num2);
		System.out.println(num1-num2);
	}

	private static int convertStringToInt(String str) {
		int num=Integer.parseInt(str);
			num=Integer.valueOf(str);
		return num;
	}	

}
