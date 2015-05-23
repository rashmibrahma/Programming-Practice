package interviewQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
/*
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, 
 * such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. 
 * For example, given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
import java.util.Queue;

/*
 * public class GraphNode {
	String label;
	List<GraphNode> neighbors;
	public GraphNode(String label){
		this.label=label;
		neighbors=new ArrayList<GraphNode>();
	}
}
 */
public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] dict={"hot","dot","dog","lot","log","pot","cog","hat","pat","cag"};
		String start="hit";
		String end="cag";
		System.out.println(wordLadder(dict,start,end));
	}

	private static int wordLadder(String[] dict, String start, String end) {
		if(dict.length==0){
			return 0;
		}
		HashSet<String> vocab=new HashSet<String>(Arrays.asList(dict));
		vocab.add(end);
		LinkedList<String> wordQueue=new LinkedList<String>();
		LinkedList<Integer> distanceQueue=new LinkedList<Integer>();
		wordQueue.add(start);
		distanceQueue.add(1);
		int result=Integer.MAX_VALUE;
		while(!wordQueue.isEmpty()){
			String currentWord=wordQueue.pop();
			Integer currentDistance=distanceQueue.pop();
			if(currentWord.equals(end)){
				result=Math.min(currentDistance, result);
			}
			for(int i=0;i<currentWord.length(); i++){
				char[] currCharArr=currentWord.toCharArray();
				for(char c='a';c<='z';c++){
					currCharArr[i]=c;
					String newWord=new String(currCharArr);
					if(vocab.contains(newWord)){
						wordQueue.add(newWord);
						distanceQueue.add(currentDistance+1);
						vocab.remove(newWord);
					}
				}
			}
		}
		return result<Integer.MAX_VALUE?result:0;
	}
}
