import java.util.ArrayDeque;
import java.util.Deque;

/*
Referring to TrieNode class in TrieAddSearchWord
TrieNode is always implemented as a nested hashmap
 */
public class StreamChecker {

    TrieNode trieNode = new TrieNode();
    Deque<Character> stream = new ArrayDeque();

    public StreamChecker(String[] words) {
        for(String word: words) {
            TrieNode node = trieNode;
            String reversedWord = new StringBuilder(word).reverse().toString();
            for (char ch : reversedWord.toCharArray()) {
                if (!node.map.containsKey(ch))
                    node.map.put(ch, new TrieNode());
                node = node.map.get(ch);
            }
            node.word = true;
        }
    }

    public boolean query(char letter) {
        stream.addFirst(letter);
        TrieNode node = trieNode;
        for(char ch: stream){
            if(node.word)
                return true;
            if(!node.map.containsKey(ch))
                return false;
            node = node.map.get(ch);
        }
        return node.word;
    }

    public static void main(String[] args) {
        String[] words = {"cd","f","kl"};
        StreamChecker obj = new StreamChecker(words);
        System.out.println(obj.query('a'));
        System.out.println(obj.query('b'));
        System.out.println(obj.query('c'));
        System.out.println(obj.query('d'));
        System.out.println(obj.query('e'));
        System.out.println(obj.query('f'));
    }
}
