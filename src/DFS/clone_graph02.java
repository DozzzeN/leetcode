package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class clone_graph02 {
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
        //测试用例有错
        System.out.println(new clone_graph02.Solution().cloneGraph(_0));
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

    //深度优先搜索
    static class Solution {
        public Node cloneGraph(Node node) {
            Map<Node, Node> nodeMap = new HashMap<>();//存储源节点和拷贝节点下
            return dfs(node, nodeMap);
        }

        public Node dfs(Node node, Map<Node, Node> nodeMap) {
            if (node == null) return null;
            if (nodeMap.containsKey(node)) return nodeMap.get(node);
            Node nodeCopy = new Node(node.val, new ArrayList<>());
            nodeMap.put(node, nodeCopy);
            for (Node neighbor : node.neighbors) {
                nodeCopy.neighbors.add(dfs(neighbor, nodeMap));
            }
            return nodeCopy;
        }
    }
}
