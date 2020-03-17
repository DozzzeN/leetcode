package BackTracking;

import java.util.HashMap;
import java.util.Map;

//138
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//要求返回这个链表的深拷贝。
//示例：
//输入：
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//解释：
//节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
//节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
//提示：
//	你必须返回给定头的拷贝作为对克隆列表的引用。
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

    //回溯算法的第一想法是将链表想象成一张图。链表中每个节点都有2个指针（图中的边）。
    //因为随机指针给图结构添加了随机性，所以我们可能会访问相同的节点多次，这样就形成了环。
    //遍历按照深度优先进行。我们需要在回溯的过程中记录已经访问过的节点，否则因为随机指针的存在我们可能会产生死循环。
    static class Solution {
        Map<Node, Node> visit = new HashMap<>();//使用map记录已经拷贝的节点的引用

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            if (visit.containsKey(head)) return visit.get(head);//防止环路死循环
            Node node = new Node(head.val, null, null);
            visit.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }
}
