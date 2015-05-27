
public class Trie {
	
	TrieNode root;
	public Trie(){
		root=new TrieNode();
	}
	
	public void addWord(String word){
		root.addWord(word.toLowerCase());
	}
	
	public boolean hasWord(String word){
		return root.hasWord(word.toLowerCase());
	}
	
	public static void main(String[] args){
		Trie trie=new Trie();
		trie.addWord("app");
		trie.addWord("apple");
		System.out.println(trie.hasWord("applel"));
	}

}
