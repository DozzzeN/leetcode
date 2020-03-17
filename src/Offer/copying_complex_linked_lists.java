package Offer;

import java.util.HashMap;
import java.util.Map;

//https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
//返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class copying_complex_linked_lists {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null) return null;
            Map<RandomListNode, RandomListNode> visit = new HashMap<>();
            RandomListNode node = pHead;
            RandomListNode nodeCopy = new RandomListNode(pHead.label);
            RandomListNode copyHead = nodeCopy;
            visit.put(node, nodeCopy);
            while (node != null) {
                nodeCopy.next = getCopiedNodeFromMap(visit, node.next);
                nodeCopy.random = getCopiedNodeFromMap(visit, node.random);
                node = node.next;
                nodeCopy = nodeCopy.next;
            }
            return copyHead;
        }

        public RandomListNode getCopiedNodeFromMap(Map<RandomListNode, RandomListNode> nodeMap, RandomListNode node) {
            if (node != null) {
                if (nodeMap.containsKey(node)) {
                    return nodeMap.get(node);
                } else {
                    nodeMap.put(node, new RandomListNode(node.label));
                    return nodeMap.get(node);
                }
            }
            return null;
        }
    }
}
