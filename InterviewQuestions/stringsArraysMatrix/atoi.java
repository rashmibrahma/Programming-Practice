package interviewQuestions;
/*
 * Problem:

Implement atoi to convert a string to an integer.

 */
public class StringToInteger {
    public static int myAtoi(String str) {
        if(str==null){
        	throw new IllegalArgumentException();
        }
        char[] strArr=str.toCharArray();
        int result=0;
        char flag='+';
        int i,num;
        if(strArr[0]=='-'){
        	flag='-';
        	num=1;
        }
        else if(strArr[0]=='+'){
        	num=1;
        }
        else{
        	num=0;
        }
        for(i=num;i<strArr.length;i++){
        	if(strArr[i]>=48 && strArr[i]<=57){
        		result=result+(strArr[i]-'0');
        	}
        	else{
        		throw new IllegalArgumentException();
        	}
        	if(i!=strArr.length-1){
        		result=result*10;
        	}
        }
        if(flag=='-'){
        	result=-result;
        }
        return result;
    }
    
    public static void main(String[] args){
    	try{
    		//System.out.println(myAtoi("ad"));
    		System.out.println(myAtoi("-23324"));
    	}
    	catch(Exception e){
    		System.out.println("not integer parsable");
    	}
    }
}
