class TrieNode {
    char c;
    public HashMap<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.c = c;
    }
}
public class Trie {
    private TrieNode root;
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        char[] wordArray = word.toCharArray();
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = cur.children;
        for (int i = 0; i < wordArray.length; i++) {
            char next = wordArray[i];
            if (curChildren.containsKey(next)) {
                cur = curChildren.get(next);
            } else {
                TrieNode nextNode = new TrieNode();
                curChildren.put(next, nextNode);
                cur = nextNode;
            }
            curChildren = cur.children;
            if (i == wordArray.length - 1) {
                cur.hasWord = true;
            }
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        if (getLastCharPos(word) == null) return false;
        if (!getLastCharPos(word).hasWord) return false;
        else return true;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        if (getLastCharPos(prefix) == null) {
            return false;
        }
        return true;
    }
    
    public TrieNode getLastCharPos(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = cur.children;
        for (char next : word.toCharArray()) {
            if (curChildren.containsKey(next)) {
                cur = curChildren.get(next);
                curChildren = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
}
