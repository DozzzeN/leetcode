package DFS;
//116
//����һ��������������������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣�������������£�
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
//��ʼ״̬�£����� next ָ�붼������Ϊ NULL��
//ʾ����
//���룺{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
//�����{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
//���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ��
//��ʾ��
//	��ֻ��ʹ�ó���������ռ䡣
//	ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�

public class populating_next_right_pointers_in_each_node {
    public static void main(String[] args) {
        Solution.Node root = new Solution.Node(1);
        root.left = new Solution.Node(2);
        root.right = new Solution.Node(3);
        root.left.left = new Solution.Node(4);
        root.left.right = new Solution.Node(5);
        root.right.left = new Solution.Node(6);
        root.right.left = new Solution.Node(7);
        Solution.Node node = new populating_next_right_pointers_in_each_node.Solution().connect(root);
        System.out.println(node);
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null) {
                root.right.next = root.next == null ? null : root.next.left;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }

        static class Node {
            public int val;
            public Node left;
            public Node right;
            public Node next;

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "val=" + val +
                        ", left=" + left +
                        ", right=" + right +
                        ", next=" + next +
                        '}';
            }
        }
    }
}
