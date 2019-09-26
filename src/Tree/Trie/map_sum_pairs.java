package Tree.Trie;

import java.util.HashMap;
import java.util.Map;

//677
//实现一个 MapSum 类里的两个方法，insert 和 sum。
//对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
//对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
//示例 1:
//输入: insert("apple", 3), 输出: Null
//输入: sum("ap"), 输出: 3
//输入: insert("app", 2), 输出: Null
//输入: sum("ap"), 输出: 5
public class map_sum_pairs {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
        System.out.println(mapSum.sum("aa"));
        mapSum.insert("aaa", 3);
        System.out.println(mapSum.sum("aaa"));
        System.out.println(mapSum.sum("bbb"));
//        mapSum.insert("a", 3);
//        System.out.println(mapSum.sum("ap"));
//        mapSum.insert("b", 2);
//        System.out.println(mapSum.sum("a"));
    }

    static class Node {
        int value;
        Map<Character, Node> next;

        public Node() {
            next = new HashMap<>();
        }


    }

    static class MapSum {
        Node root;
        int sum;

        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node node = root;
            for (int i = 0; i < key.length(); i++) {
                if (node.next.get(key.charAt(i)) == null) {
                    node.next.put(key.charAt(i), new Node());
                }
                node = node.next.get(key.charAt(i));
            }
            node.value = val;
        }

        public int sum(String prefix) {
            sum = 0;
            Node node = root;
            int result = 0;
            for (int i = 0; i < prefix.length(); i++) {
                Node next = node.next.get(prefix.charAt(i));
                if (next == null) {
                    return 0;
                }
                node = next;
            }
            result = node.value + sum(node);
            return result;
        }

        public int sum(Node node) {
            if (node.next == null || node.next.size() == 0) {
                return sum;
            } else {
                for (Character character : node.next.keySet()) {
                    sum += node.next.get(character).value;
                    sum(node.next.get(character));
                }
            }
            return sum;
        }
    }
}
