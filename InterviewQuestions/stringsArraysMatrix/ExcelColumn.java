package leetCode_easy;

import java.util.HashMap;

public class ExcelColumn {
    public static String convertToTitle(int n) {
        char letter=65;
        if(n>=1 && n<=26){
            letter = (char) (letter+n-1);
            return letter+"";
        }
        HashMap<Integer, String> charMap=new HashMap<Integer, String>();
        
        for(int i=1; i<=26; i++){
            charMap.put(i, letter+"");
            letter++;
        }
        String title="";
        int flag=0;
        String mapVal;
        while(n>26){
            if(n%26==0 || n%26==26){
                title="Z"+title;  //0-->Z special case
                flag=1;
            }
            else if(n%26>=1){
                mapVal=charMap.get(n%26);
                title=mapVal+title;
                flag=0;
            }
            if(flag==1){    //special case for Z
                int quot=n/26;
                if(quot <= 26){
                    title=charMap.get(quot-1) + title;
                }
                else{
                	n=quot;
                }
            }
            else{
                int quot=n/26;
                if(quot <= 26){
                    title=charMap.get(quot) + title;
                    break;
                }
                else{
                    n=quot;
                }
            }
        }
        return title;
    }
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertToTitle(703));
	}
}
