package pers;

/**
 * @author qiaozhe
 * @date 2022/1/14
 */
public class Trie {

    Trie[] child;
    boolean over;

    public Trie() {
        child = new Trie[26];
    }

    public void insert(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.child[word.charAt(i) - 'a'] == null) {
                temp.child[word.charAt(i) - 'a'] = new Trie();
            }
            temp = temp.child[word.charAt(i) - 'a'];
        }
        temp.over = true;
    }

    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.child[word.charAt(i) - 'a'] == null) {
                return false;
            }
            temp = temp.child[word.charAt(i) - 'a'];
        }
        return temp.over;
    }

    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.child[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            temp = temp.child[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.search("apps");
        System.out.println(trie.search("app"));
    }

}
