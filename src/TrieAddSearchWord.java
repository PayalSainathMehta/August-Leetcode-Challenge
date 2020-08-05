import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> map = new HashMap();
    boolean word = false;
    public TrieNode(){}
}

public class TrieAddSearchWord {
	 /** Initialize your data structure here. */
    TrieNode trieNode;
    
    public TrieAddSearchWord() {
        trieNode = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trieNode;
        for(char ch: word.toCharArray()){
            if(!node.map.containsKey(ch))
                node.map.put(ch, new TrieNode());
            node = node.map.get(ch);
        }
        node.word = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, trieNode);
    }

    public boolean searchInNode(String word, TrieNode node) {
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.map.containsKey(ch)){
                if(ch == '.'){
                    for(char x: node.map.keySet()){
                        TrieNode child = node.map.get(x);
                        if(searchInNode(word.substring(i+1), child))
                            return true;
                    }        
                }
                return false;
            }
            else{
                node = node.map.get(ch);
            }
        }
        return node.word;
    }
}
