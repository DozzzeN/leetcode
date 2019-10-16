package DynamicProgramming;

import java.util.Arrays;

//96
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//示例:
//输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class unique_binary_search_trees {
    public static void main(String[] args) {
        System.out.println(new unique_binary_search_trees.Solution().numTrees(8));
    }

    //count[i]是以[0,i]产生的唯一二叉树数目
    //count[0] = count[1] = 1
    //count[2] = count[0]*count[1] + count[1]*count[0]
    //count[0]*count[1]是1是根的情况 count[1]*count[0]是0是根的情况
    //count[i] = ∑ count[0...k] * count[k+1...i] 0 <= k < i-1
    static class Solution {
        public int numTrees(int n) {
            int[] count = new int[n + 1];
            count[0] = count[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    count[i] += count[j] * count[i - j - 1];
                }
            }
            return count[n];
        }
    }
}
