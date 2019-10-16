package LinkedList;

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
public class copy_list_with_random_pointer {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public static void main(String[] args) {
        Node one = new Node();
        one.val = -1;
        one.next = null;
        one.random = null;
        System.out.println(new copy_list_with_random_pointer.Solution().copyRandomList(one));
    }

    //ԭ�����в��뿽���ڵ㣬��������ÿһ���ڵ�N����һ�����ƽڵ�N'���뵽N����
    //�������ָ�룬�ٴα���������ÿ���ڵ�N����һ�����ָ����N'�ϣ�Ȼ����ָ����󣬱���N�����ָ��ָ��M����ôN'�����ָ��ָ��M'
    //��������Ϊ��������
    static class Solution {
        public Node copyRandomList(Node head) {
            Node cur = head;
            while (cur != null) {
                Node nodeCopy = new Node(cur.val, new Node(), new Node());
                nodeCopy.next = cur.next;
                cur.next = nodeCopy;
                cur = nodeCopy.next;
            }
            //�������ָ��
            cur = head;
            while (cur != null) {
                Node randomCopy = cur.next;
                if (cur.random != null) {
                    randomCopy.random = cur.random.next;
                } else {
                    randomCopy.random = null;
                }
                cur = randomCopy.next;
            }
            //�������
            cur = head;
            Node copyHead = head == null ? null : head.next;
            while (cur != null) {
                Node nodeCopy = cur.next;
                cur.next = nodeCopy.next;
                //���Ӹ��ƵĽڵ�
                if (nodeCopy.next != null) {
                    nodeCopy.next = nodeCopy.next.next;
                }
                cur = cur.next;
            }
            return copyHead;
        }
    }
}
