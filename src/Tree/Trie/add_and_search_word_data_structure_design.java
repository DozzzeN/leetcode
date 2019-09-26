package Tree.Trie;

import java.util.HashMap;
import java.util.Map;

//211
//���һ��֧���������ֲ��������ݽṹ��
//void addWord(word)
//bool search(word)
//search(word) �����������ֻ�������ʽ�ַ������ַ���ֻ������ĸ . �� a-z �� . ���Ա�ʾ�κ�һ����ĸ��
//ʾ��:
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
                    //ע����ֱ�ӷ��ص�����
                    //return search(word, node.next.get(character), depth + 1);
                    if (search(word, node.next.get(character), depth + 1)) {
                        return true;
                    }
                }
                //ѭ���궼û���ҵ�
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
