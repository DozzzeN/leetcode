package BackTracking;

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
public class copy_list_with_random_pointer03 {
    public static void main(String[] args) {
        Node one = new Node();
        Node two = new Node();
        one.val = 1;
        two.val = 2;
        one.next = two;
        one.random = two;
        two.next = null;
        two.random = two;
        System.out.println(new copy_list_with_random_pointer03.Solution().copyRandomList(one));
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

    //�����㷨�ĵ�һ�뷨�ǽ����������һ��ͼ��������ÿ���ڵ㶼��2��ָ�루ͼ�еıߣ���
    //��Ϊ���ָ���ͼ�ṹ���������ԣ��������ǿ��ܻ������ͬ�Ľڵ��Σ��������γ��˻���
    //��������������Ƚ��С�������Ҫ�ڻ��ݵĹ����м�¼�Ѿ����ʹ��Ľڵ㣬������Ϊ���ָ��Ĵ������ǿ��ܻ������ѭ����
    static class Solution {
        Map<Node, Node> visit = new HashMap<>();//ʹ��map��¼�Ѿ������Ľڵ������

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            if (visit.containsKey(head)) return visit.get(head);//��ֹ��·��ѭ��
            Node node = new Node(head.val, null, null);
            visit.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }
}
