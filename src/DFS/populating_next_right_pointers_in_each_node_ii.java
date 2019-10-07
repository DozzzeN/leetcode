package DFS;
//117
//给定一个二叉树
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//初始状态下，所有 next 指针都被设置为 NULL。
//示例：
//输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
//输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
//	你只能使用常量级额外空间。
//	使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。


//特殊情况的处理
//          1
//         / \
//        2   3
//       / \   \
//      4   5   6
//     /         \
//    7 --------> 8
public class populating_next_right_pointers_in_each_node_ii {
    public static void main(String[] args) {
        Solution.Node root = new Solution.Node(1);
        root.left = new Solution.Node(2);
        root.right = new Solution.Node(3);
        root.left.left = new Solution.Node(4);
        root.left.right = new Solution.Node(5);
        root.right.left = new Solution.Node(6);
        root.right.left = new Solution.Node(7);
        Solution.Node node = new populating_next_right_pointers_in_each_node_ii.Solution().connect(root);
        System.out.println(node);
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            //第一个有效的兄弟节点（从7到8的过程）
            Node p = root.next;
            while (p != null) {
                if (p.left != null) {
                    p = p.left;
                    break;
                }
                if (p.right != null) {
                    p = p.right;
                    break;
                }
                p = p.next;
            }
            if (root.left != null) {
                root.left.next = root.right == null ? p : root.right;
            }
            if (root.right != null) {
                root.right.next = p;
            }
            //特别注意，先递归右子树，否则无法找到正确的兄弟节点
            connect(root.right);
            connect(root.left);
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
