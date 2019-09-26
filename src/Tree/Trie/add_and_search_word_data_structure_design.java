package Tree.Trie;

import java.util.HashMap;
import java.util.Map;

//211
//设计一个支持以下两种操作的数据结构：
//void addWord(word)
//bool search(word)
//search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
//示例:
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
public class add_and_search_word_data_structure_design {
    public static void main(String[] args) {
        WordDictionary word = new WordDictionary();
        word.addWord("at");
        word.addWord("bat");
        System.out.println(word.search(".at"));
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

    static class WordDictionary {
        private Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
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
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(word, root, 0);
        }

        public boolean search(String word, Node node, int depth) {
            if (depth == word.length()) {
                return node.isWord;
            }
            if (word.charAt(depth) == '.') {
                for (Character character : node.next.keySet()) {
                    //注意与直接返回的区别
                    //return search(word, node.next.get(character), depth + 1);
                    if (search(word, node.next.get(character), depth + 1)) {
                        return true;
                    }
                }
                //循环完都没有找到
                return false;
            } else {
                if (node.next.get(word.charAt(depth)) == null) {
                    return false;
                } else {
                    return search(word, node.next.get(word.charAt(depth)), depth + 1);
                }
            }
        }
    }
}
