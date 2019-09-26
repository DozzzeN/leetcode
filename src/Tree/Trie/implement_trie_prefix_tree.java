package Tree.Trie;

import java.util.HashMap;
import java.util.Map;

//208
//ʵ��һ�� Trie (ǰ׺��)������ insert, search, �� startsWith ������������
//ʾ��:
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // ���� true
//trie.search("app");     // ���� false
//trie.startsWith("app"); // ���� true
//trie.insert("app");
//trie.search("app");     // ���� true
public class implement_trie_prefix_tree {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // ���� true
        System.out.println(trie.search("app"));     // ���� false
        System.out.println(trie.startsWith("app")); // ���� true
        trie.insert("app");
        System.out.println(trie.search("app"));     // ���� true
    }

    static class Node {
        boolean isWord;
        Map<Character, Node> next;

        public Node() {
            next = new HashMap<>();
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
        }
    }


    static class Trie {
        Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.next.get(word.charAt(i)) == null) {
                    node.next.put(word.charAt(i), new Node());
                }
                node = node.next.get(word.charAt(i));
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.next.get(word.charAt(i)) == null) {
                    return false;
                }
                node = node.next.get(word.charAt(i));
            }
            return node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (node.next.get(prefix.charAt(i)) == null) {
                    return false;
                }
                node = node.next.get(prefix.charAt(i));
            }
            return true;
        }
    }
}
