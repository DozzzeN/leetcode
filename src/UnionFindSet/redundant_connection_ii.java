package UnionFindSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//685
//在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
//输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
//结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u and v和顶点的边，其中父节点u是子节点v的一个父节点。
//返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
//示例 1:
//输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的有向图如下:
//  1
// / \
//v   v
//2-->3
//示例 2:
//输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//输出: [4,1]
//解释: 给定的有向图如下:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
//注意:
//	二维数组大小的在3到1000范围内。
//	二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
public class redundant_connection_ii {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}
        };
        System.out.println(Arrays.toString(new redundant_connection_ii.Solution().findRedundantDirectedConnection(edges)));
    }

    //核心思路：考虑三种情况：1.整个图有环，没有入度大于1的节点，删除最后一个形成环的边
    //2.整个图没有环，有入度大于1的节点，删除最后一条使得入度大于1的边
    //3.整个图既有环又有入度大于1的节点，先试探将2的边删除后剩下的边会不会成环，不成环则2的边为所求，否则删除入度大于1节点的第一条边

    //代码有错误
    static class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            UnionFindSet unionFindSet = new UnionFindSet(edges.length);
            List<Integer> node = new ArrayList<>();
            int[] dupNode = new int[2];
            for (int i = 0; i < edges.length; i++) {
                if (!node.contains(edges[i][1])) {
                    node.add(edges[i][1]);
                } else {
                    dupNode[1] = edges[i][1];
                }
            }
            for (int i = edges.length - 1; i > 0; i--) {
                if (edges[i][1] == dupNode[1]) {
                    dupNode[0] = edges[i][0];
                    break;
                }
            }
            if (dupNode[0] != 0) return dupNode;
            else for (int i = 0; i < edges.length; i++) {
                unionFindSet.Union(edges[i][0], edges[i][1]);
            }
            for (int i = 0; i < edges.length; i++) {
                if (unionFindSet.Find(i) != i) {
                    dupNode[1] = edges[i][0];
                }
            }
            for (int i = edges.length - 1; i > 0; i--) {
                if (edges[i][1] == dupNode[1]) {
                    dupNode[0] = edges[i][0];
                    break;
                }
            }
            return dupNode;
        }
    }
}
