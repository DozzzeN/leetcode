package Array_Matrix;

import java.util.Arrays;

//667
//给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
//
//① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
//
//② 如果存在多种答案，你只需实现并返回其中任意一种.
public class beautiful_arrangement_ii {
    public static void main(String[] args) {
        int[] result = new beautiful_arrangement_ii.Solution().constructArray(7, 4);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] constructArray(int n, int k) {
            //形成如下序列（在此序列的前k+1个元素中已经用完了所有的k）
            //1 1+k 1+k-(k-1) 1+k-(k-1)+(k-2) ...
            //n=3 k=2 [1]-3-[2]
            //n=7 k=3 ([1]-4-[2]-3)-5-6-7
            //n=9 k=4 ([1]-5-[2]-4-[3])-6-7-8-9
            //n=11 k=5 ([1]-6-[2]-5-[3]-4)-7-8-9-10-11
            int[] result = new int[n];
            result[0] = 1;
            for (int j = 1; j <= k; j++) {
                if (j % 2 == 1) {
                    result[j] = result[j - 1] + k + 1 - j;
                } else {
                    result[j] = result[j - 1] - k - 1 + j;
                }
            }
            for (int j = k + 1; j < n; j++) {
                result[j] = j + 1;
            }
            return result;
        }
    }
}
