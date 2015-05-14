package leetCode_easy;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        String dict="";
        for(String word:wordDict){
            dict=dict+word;
        }
        dict=dict.replaceAll("\\s+", "");
        return (dict.contains(s));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> wordDict=new HashSet<String>();
		/*wordDict.add("leet");
		wordDict.add("csdf");//"abcd", ["a","abc","b","cd"]
		System.out.println(wordBreak("leetcode", wordDict));*/
		
		wordDict.add("a");
		wordDict.add("abc");
		wordDict.add("b");
		wordDict.add("cd");
		System.out.println(wordBreak("abcd", wordDict));
		//public static void main(String[] args) {
			HashSet<String> dict = new HashSet<String>();
			dict.add("a");
			dict.add("abc");
			dict.add("b");
			dict.add("cd");
		 
			StringBuilder sb = new StringBuilder();
		 
			for(String s: dict){
				sb.append(s + "|");
			}
		 
			String pattern = sb.toString().substring(0, sb.length()-1);
			pattern = "("+pattern+")*";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher("abcdb");
		 
			if(m.matches()){
				System.out.println("match");
			}
		//}
	}

}
