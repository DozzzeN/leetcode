package BFS;

import java.util.*;

//133
//给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
//提示：
//	节点数介于 1 到 100 之间。
//	无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
//	由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
//	必须将给定节点的拷贝作为对克隆图的引用返回。

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

    //广度优先搜索
    static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Map<Node, Node> nodeMap = new HashMap<>();//存储源节点和拷贝节点下
            Queue<Node> visit = new LinkedList<>();
            visit.offer(node);
            Node nodeCopy = new Node(node.val, new ArrayList<>());
            nodeMap.put(node, nodeCopy);
            while (!visit.isEmpty()) {
                Node cur = visit.poll();
                for (Node neighbor : cur.neighbors) {
                    if (!nodeMap.containsKey(neighbor)) {//map里面没有邻居节点，创建一个加入map
                        nodeMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        visit.offer(neighbor);
                    }
                    //然后将邻居节点加入cur节点的邻居字段中
                    nodeMap.get(cur).neighbors.add(nodeMap.get(neighbor));
                }
            }
            return nodeCopy;
        }
    }
}
