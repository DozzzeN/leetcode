package DynamicProgramming;

//��һ����Ϊn������a0,a1,...,an-1����������������������������еĳ��ȡ�
//����������ָ���Ƕ��������i<j������ai<aj�������С�

//����
//n=5
//a={4��2��3��1��5}

import java.util.Arrays;

//���
//3(a1,a2,a4���ɵ�������2��3��5�)
public class ����������� {
    //dp[i]:=��ai��β������������еĳ���
    //dp[i]=max{1,dp[j]+1|j<i��aj<ai}
    //1��������ֻ����ai�����
    int n = 5;
    int[] a = new int[]{4, 2, 3, 1, 5};
    int[] dp = new int[n];

    public static void main(String[] args) {
        new �����������().solve();
        new �����������().solve02();
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

    //dp[i]:=����Ϊi+1��������������ĩβԪ�ص���Сֵ(�����ڵĻ�����INF)
    //INF   INF   INF   INF   INF  ��ʼdp
    //4     INF   INF   INF   INF  ����4
    //2     INF   INF   INF   INF  ����2
    //2     3     INF   INF   INF  ����3
    //1     3     INF   INF   INF  ����1
    //1     3     5     INF   INF  ����5
    //dp[2]=5�������������г���Ϊ3

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
        int right = nums.length; // ע��

        while (left < right) { // ע��
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // ע��
            }
        }
        return left;
    }
}
