package LinkedList;

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
            Map<Node, Node> visit = new HashMap<>();//使用map记录已经拷贝的节点的引用
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
