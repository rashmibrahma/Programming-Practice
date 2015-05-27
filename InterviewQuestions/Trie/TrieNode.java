


public class TrieNode {
	TrieNode[] children;
	boolean isLeaf;
	boolean isWord;
	char label;
	public TrieNode(){
		children=new TrieNode[26];
		isLeaf=true;
		isWord=false;
	}
	public TrieNode(char character){
		this();
		label=character;
	}
	
	protected void addWord(String word){
		isLeaf=false;
		int charPos=word.charAt(0)-'a';
		if(children[charPos]==null){
			children[charPos]=new TrieNode(word.charAt(0));
		}
		if(word.length()>1){
			children[charPos].addWord(word.substring(1));
		}
		else{
			children[charPos].isWord=true;
		}
	}
	
	protected boolean hasWord(String word){
				
		if(isLeaf){
			return false;
		}
		int pos=word.charAt(0)-'a';
		if(children[pos]==null){
			return false;
		}
		else if(children[pos].label==word.charAt(0) && word.length()>=2){
			return children[pos].hasWord(word.substring(1));
		}
		return true;
	}
}
