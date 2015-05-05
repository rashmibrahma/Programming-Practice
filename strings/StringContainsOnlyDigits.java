package strings;

public class StringContainsOnlyDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			containsDigits("asd34afv");
		}
		catch(NullValue e){
			e.printStackTrace();
		}
		catch(EmptyString e){
			e.printStackTrace();
		}
	}

	private static void containsDigits(String str) throws NullValue, EmptyString{
		
		if(str==null){
			throw new NullValue("Null Value");
		}
		//if string is empty
		if(str.length()==0){
			throw new EmptyString("Empty String");
		}
		
		System.out.println();
		
	}

}
