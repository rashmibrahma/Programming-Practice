package strings;

public class ReplaceChar {

	/**
	 * How to replace each given character to other e.g. blank with %20?
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(replaceCharacter("Java is Great"));
	}

	private static String replaceCharacter(String str) {
		
		return str.replace(" ", "%20");
		
	}

}
