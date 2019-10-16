package LinkedList;

import java.util.HashMap;
import java.util.Map;

//138
//����һ������ÿ���ڵ����һ���������ӵ����ָ�룬��ָ�����ָ�������е��κνڵ��սڵ㡣
//Ҫ�󷵻��������������
//ʾ����
//���룺
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//���ͣ�
//�ڵ� 1 ��ֵ�� 1��������һ��ָ������ָ�붼ָ��ڵ� 2 ��
//�ڵ� 2 ��ֵ�� 2��������һ��ָ��ָ�� null�����ָ��ָ�����Լ���
//��ʾ��
//	����뷵�ظ���ͷ�Ŀ�����Ϊ�Կ�¡�б�����á�
public class copy_list_with_random_pointer02 {
    public static void main(String[] args) {
        Node one = new Node();
        Node two = new Node();
        one.val = 1;
        two.val = 2;
        one.next = two;
        one.random = two;
        two.next = null;
        two.random = two;
        System.out.println(new copy_list_with_random_pointer02.Solution().copyRandomList(one));
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> visit = new HashMap<>();//ʹ��map��¼�Ѿ������Ľڵ������
            if (head == null) return null;
            Node node = head;
            Node nodeCopy = new Node(node.val, null, null);
            Node copyHead = nodeCopy;
            visit.put(node, nodeCopy);
            while (node != null) {
                nodeCopy.next = getCopiedNodeFromMap(visit, node.next);
                nodeCopy.random = getCopiedNodeFromMap(visit, node.random);
                node = node.next;
                nodeCopy = nodeCopy.next;
            }
            return copyHead;
        }

        public Node getCopiedNodeFromMap(Map<Node, Node> nodeMap, Node node) {
            if (node != null) {
                if (nodeMap.containsKey(node)) {
                    return nodeMap.get(node);
                } else {
                    nodeMap.put(node, new Node(node.val, null, null));
                    return nodeMap.get(node);
                }
            }
            return null;
        }
    }
}
