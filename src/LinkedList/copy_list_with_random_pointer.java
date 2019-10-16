package LinkedList;

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

    //原链表中插入拷贝节点，遍历链表，每一个节点N生成一个复制节点N'插入到N后面
    //复制随机指针，再次遍历链表，对每个节点N生成一个随机指针在N'上，然后复制指针对象，比如N的随机指针指向M，那么N'的随机指针指向M'
    //将链表拆分为两个链表
    static class Solution {
        public Node copyRandomList(Node head) {
            Node cur = head;
            while (cur != null) {
                Node nodeCopy = new Node(cur.val, new Node(), new Node());
                nodeCopy.next = cur.next;
                cur.next = nodeCopy;
                cur = nodeCopy.next;
            }
            //拷贝随机指针
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
            //拆分链表
            cur = head;
            Node copyHead = head == null ? null : head.next;
            while (cur != null) {
                Node nodeCopy = cur.next;
                cur.next = nodeCopy.next;
                //连接复制的节点
                if (nodeCopy.next != null) {
                    nodeCopy.next = nodeCopy.next.next;
                }
                cur = cur.next;
            }
            return copyHead;
        }
    }
}
