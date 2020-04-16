package Offer;

import java.util.HashMap;
import java.util.Map;

//https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
//���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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

        public RandomListNode Clone02(RandomListNode pHead) {
            if (pHead == null) return null;
            //�����½ڵ�
            RandomListNode cur = pHead;
            while (cur != null) {
                RandomListNode clone = new RandomListNode(cur.label);
                clone.next = cur.next;
                cur.next = clone;
                cur = clone.next;
            }
            //����random����
            cur = pHead;
            while (cur != null) {
                RandomListNode clone = cur.next;
                if (cur.random != null)
                    clone.random = cur.random.next;//1`�Ŀ�¡ָ��2�Ŀ�¡��next����2`�Ŀ�¡
                cur = clone.next;
            }
            //���
            cur = pHead;
            RandomListNode pCloneHead = pHead.next;
            while (cur.next != null) {
                RandomListNode next = cur.next;
                cur.next = next.next;
                cur = next;
            }
            return pCloneHead;
        }
    }
}
