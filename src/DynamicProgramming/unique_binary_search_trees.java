package DynamicProgramming;

import java.util.Arrays;

//96
//����һ������ n������ 1 ... n Ϊ�ڵ���ɵĶ����������ж����֣�
//ʾ��:
//����: 3
//���: 5
//����:
//���� n = 3, һ���� 5 �ֲ�ͬ�ṹ�Ķ���������:
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class unique_binary_search_trees {
    public static void main(String[] args) {
        System.out.println(new unique_binary_search_trees.Solution().numTrees(8));
    }

    //count[i]����[0,i]������Ψһ��������Ŀ
    //count[0] = count[1] = 1
    //count[2] = count[0]*count[1] + count[1]*count[0]
    //count[0]*count[1]��1�Ǹ������ count[1]*count[0]��0�Ǹ������
    //count[i] = �� count[0...k] * count[k+1...i] 0 <= k < i-1
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
