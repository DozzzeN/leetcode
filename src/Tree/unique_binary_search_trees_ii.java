package Tree;

import java.util.ArrayList;
import java.util.List;

//95
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//示例:
//输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class unique_binary_search_trees_ii {
    public static void main(String[] args) {
        System.out.println(new unique_binary_search_trees_ii.Solution().generateTrees(0));
    }

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> result = new ArrayList<>();
            if (start > end) {
                result.add(null);
                return result;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubTree = generateTrees(start, i - 1);
                List<TreeNode> rightSubTree = generateTrees(i + 1, end);
                for (int j = 0; j < leftSubTree.size(); j++) {
                    for (int k = 0; k < rightSubTree.size(); k++) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftSubTree.get(j);
                        node.right = rightSubTree.get(k);
                        result.add(node);
                    }
                }
            }
            return result;
        }
    }
}
