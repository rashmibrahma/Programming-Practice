package checkValidIP;


public class CheckValidIP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isValidIP("10.25.200.162:432"));
		System.out.println(isValidIP("a.b.c.d:3223"));
		System.out.println(isValidIP("a.d:32"));
		System.out.println(isValidIP(""));
		System.out.println(isValidIP(null));
	}

	private static boolean isValidIP(String inputIP) {
		if(inputIP == null){
			return false;
		}
		
		String[] splitIP=inputIP.split("\\.");
		if(splitIP.length!=4){
			return false;
		}
		try{
			String[] splitColon=splitIP[3].split(":");
			if(splitColon.length!=2){
				return false;
			}
			else if(Integer.parseInt(splitColon[1])<0 || Integer.parseInt(splitColon[1])>65535){
				return false;
			}
			else if(Integer.parseInt(splitColon[0])<0 || Integer.parseInt(splitColon[0])>255){
				return false;
			}
			
			for(int i=0; i<splitIP.length-1; i++){
				if(Integer.parseInt(splitIP[i])<0 || Integer.parseInt(splitIP[i])>255){
					return false;
				}
			}
		}
		catch(Exception e){
			if(e instanceof NumberFormatException){
				return false;
			}
		}
		return true;
	}

}
