package Tree.Trie;

import java.util.Map;
import java.util.TreeMap;
//前缀树
//                  root
//                 / | \
//                s  p  d
//                |  |  |
//                e  a  o
//                | / \ |
//                e i n g
//                  | |
//                  n d
//                    |
//                    a
//(see pain panda dog)

public class Trie {
    private static class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }

        public Node(boolean isWord) {
            this();
            this.isWord = isWord;
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //插入单词
    public void add(String word) {
        Node current = root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            Node next = current.next.get(c);
            if (next == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }

        if (!current.isWord) {
            size++;
            current.isWord = true;
        }
    }

    //查找单词
    public boolean contains(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = current.next.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        //如果只存在panda这个词，查询pan，虽然有这3个字母，但是并不存在该单词
        return current.isWord;
    }

    //查询包含前缀
    public boolean containsPrefix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node node = current.next.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    //删除
    /*
     * 1，如果单词是另一个单词的前缀，只需要把该word的最后一个节点的isWord的改成false
     * 2，如果单词的所有字母的都没有多个分支，删除整个单词
     * 3，如果单词的除了最后一个字母，其他的字母有多个分支，
     */
    public boolean remove(String word) {
        Node multiChildNode = null;
        int multiChildNodeIndex = -1;
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Node child = current.next.get(word.charAt(i));
            //没有这个单词
            if (child == null) {
                return false;
            }
            //当前节点的子节点大于1个
            if (child.next.size() > 1) {
                multiChildNodeIndex = i;
                multiChildNode = child;
            }
            current = child;
        }
        //单词后面还有子节点
        if (current.next.size() > 0) {
            if (current.isWord) {
                current.isWord = false;
                size--;
                return true;
            }
            //不存在此单词，此单词只是前缀
            return false;
        }
        //单词的所有字母都没有多个分支，删除整个单词
        if (multiChildNodeIndex == -1) {
            root.next.remove(word.charAt(0));
            size--;
        }
        //单词除了最后一个字母，其他字母都有分支
        if (multiChildNodeIndex != word.length() - 1) {
            multiChildNode.next.remove(word.charAt(multiChildNodeIndex + 1));
            size--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("flower");
        System.out.println(trie.contains("flower"));
        trie.add("flow");
        System.out.println(trie.containsPrefix("flo"));
    }
}
