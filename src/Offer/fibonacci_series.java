package Offer;

//https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
//n<=39
public class fibonacci_series {
    public static void main(String[] args) {
        System.out.println(new fibonacci_series.Solution().Fibonacci(3));
        System.out.println(new fibonacci_series.Solution().Fibonacci2(100));
    }

    public static class Solution {
        public int Fibonacci(int n) {
            if (n == 0) return 0;
            if (n <= 1) return 1;
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

        public long Fibonacci2(int n) {
            long[] memo = new long[n + 1];
            memo[0] = 0;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
            return memo[n];
        }
    }
}
