package Design;

import java.util.HashMap;
import java.util.Map;

//146
//�����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������ơ���Ӧ��֧�����²����� ��ȡ���� get �� д������ put ��
//��ȡ���� get(key) - �����Կ (key) �����ڻ����У����ȡ��Կ��ֵ�����������������򷵻� -1��
//д������ put(key, value) - �����Կ�����ڣ���д��������ֵ�������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ���������ʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
//����:
//���Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����
//ʾ��:
//LRUCache cache = new LRUCache( 2 /* �������� */ );
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // ����  1
//cache.put(3, 3);    // �ò�����ʹ����Կ 2 ����
//cache.get(2);       // ���� -1 (δ�ҵ�)
//cache.put(4, 4);    // �ò�����ʹ����Կ 1 ����
//cache.get(1);       // ���� -1 (δ�ҵ�)
//cache.get(3);       // ����  3
//cache.get(4);       // ����  4
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
                //����
                //ɾ��ԭλ��
                removeNode(node);
                //���ĩβ
                addNode(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            //���ڴ�key
            if (this.map.containsKey(key)) {
                Node node = this.map.get(key);
                node.value = value;
                //�������
                if (node == this.end) return;
                //ɾ��ԭλ��
                removeNode(node);
                //���ĩβ
                addNode(node);
            } else {
                if (this.capacity <= this.map.size()) {
                    //��Ҫ����
                    Node oldNode = this.head;
                    this.head = this.head.next;
                    this.map.remove(oldNode.key);
                }
                //ֱ����� �Լ� �����Ժ�һ�����
                Node node = new Node(key, value);
                //��ӵ����
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
