package BFS;

import java.util.*;

//133
//����������ͨͼ��һ���ڵ�����ã����ظ�ͼ���������¡����ͼ�е�ÿ���ڵ㶼��������ֵ val��Int�� �����ھӵ��б�list[Node]����
//��ʾ��
//	�ڵ������� 1 �� 100 ֮�䡣
//	����ͼ��һ����ͼ������ζ��ͼ��û���ظ��ıߣ�Ҳû���Ի���
//	����ͼ������ģ�����ڵ� p �ǽڵ� q ���ھӣ���ô�ڵ� q Ҳ�����ǽڵ� p ���ھӡ�
//	���뽫�����ڵ�Ŀ�����Ϊ�Կ�¡ͼ�����÷��ء�

//     1
//    / \
//   0 - 2
//      / \
//      \_/
public class clone_graph {
    public static void main(String[] args) {
        Node _0 = new Node();
        Node _1 = new Node();
        Node _2 = new Node();
        List<Node> _0Neighbors = new ArrayList<>();
        _0Neighbors.add(_1);
        _0Neighbors.add(_2);
        List<Node> _1Neighbors = new ArrayList<>();
        _1Neighbors.add(_0);
        _1Neighbors.add(_2);
        List<Node> _2Neighbors = new ArrayList<>();
        _2Neighbors.add(_2);
        _2Neighbors.add(_0);
        _2Neighbors.add(_1);
        _0 = new Node(0, _0Neighbors);
        _1 = new Node(1, _1Neighbors);
        _2 = new Node(2, _2Neighbors);
        System.out.println(new clone_graph.Solution().cloneGraph(_0));
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //�����������
    static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Map<Node, Node> nodeMap = new HashMap<>();//�洢Դ�ڵ�Ϳ����ڵ���
            Queue<Node> visit = new LinkedList<>();
            visit.offer(node);
            Node nodeCopy = new Node(node.val, new ArrayList<>());
            nodeMap.put(node, nodeCopy);
            while (!visit.isEmpty()) {
                Node cur = visit.poll();
                for (Node neighbor : cur.neighbors) {
                    if (!nodeMap.containsKey(neighbor)) {//map����û���ھӽڵ㣬����һ������map
                        nodeMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        visit.offer(neighbor);
                    }
                    //Ȼ���ھӽڵ����cur�ڵ���ھ��ֶ���
                    nodeMap.get(cur).neighbors.add(nodeMap.get(neighbor));
                }
            }
            return nodeCopy;
        }
    }
}
