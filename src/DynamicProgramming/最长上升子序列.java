package DynamicProgramming;

//有一个长为n的数列a0,a1,...,an-1。请求出这个序列中最长的上升子序列的长度。
//上升子序列指的是对于任意的i<j都满足ai<aj的子序列。

//输入
//n=5
//a={4，2，3，1，5}

import java.util.Arrays;

//输出
//3(a1,a2,a4构成的子序列2，3，5最长)
public class 最长上升子序列 {
    //dp[i]:=以ai结尾的最长上升子序列的长度
    //dp[i]=max{1,dp[j]+1|j<i且aj<ai}
    //1是子序列只包括ai的情况
    int n = 5;
    int[] a = new int[]{4, 2, 3, 1, 5};
    int[] dp = new int[n];

    public static void main(String[] args) {
        new 最长上升子序列().solve();
        new 最长上升子序列().solve02();
    }


    //O(n^2)
    public void solve() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }

    //dp[i]:=长度为i+1的上升子序列中末尾元素的最小值(不存在的话就是INF)
    //INF   INF   INF   INF   INF  初始dp
    //4     INF   INF   INF   INF  插入4
    //2     INF   INF   INF   INF  插入2
    //2     3     INF   INF   INF  插入3
    //1     3     INF   INF   INF  插入1
    //1     3     5     INF   INF  插入5
    //dp[2]=5，故上升子序列长度为3

    //O(nlogn)
    public void solve02() {
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[left_bound(dp, a[i])] = a[i];
        }
        System.out.println(left_bound(dp, Integer.MAX_VALUE));
    }

    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
}
