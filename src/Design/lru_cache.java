package Design;

import java.util.HashMap;
import java.util.Map;

//146
//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//进阶:
//你是否可以在 O(1) 时间复杂度内完成这两种操作？
//示例:
//LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
public class lru_cache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    static class LRUCache {
        private Map<Integer, Node> map;
        private int capacity;
        private Node head;
        private Node end;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if (this.map.containsKey(key)) {
                Node node = this.map.get(key);
                if (this.end == node) return node.value;
                //重排
                //删除原位置
                removeNode(node);
                //添加末尾
                addNode(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            //存在此key
            if (this.map.containsKey(key)) {
                Node node = this.map.get(key);
                node.value = value;
                //无需更新
                if (node == this.end) return;
                //删除原位置
                removeNode(node);
                //添加末尾
                addNode(node);
            } else {
                if (this.capacity <= this.map.size()) {
                    //需要重排
                    Node oldNode = this.head;
                    this.head = this.head.next;
                    this.map.remove(oldNode.key);
                }
                //直接添加 以及 重排以后一起添加
                Node node = new Node(key, value);
                //添加到最后
                addNode(node);
                this.map.put(key, node);
            }
        }

        private void removeNode(Node node) {
            if (node == this.head && node == this.end) {
                this.head = null;
                this.end = null;
            } else if (node == this.head) {
                this.head = this.head.next;
                this.head.pre = null;
            } else if (node == this.end) {
                this.end = this.end.pre;
                this.end.next = null;
            } else {
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }
        }

        private void addNode(Node node) {
            if (this.head == null) {
                this.head = node;
            }
            if (this.end != null) {
                this.end.next = node;
                node.pre = this.end;
                node.next = null;
            }
            this.end = node;
        }

        class Node {
            private Node next;
            private Node pre;
            private int key;
            private int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
