package NumberTheory;

import java.util.*;

public class 素性测试 {
    public static void main(String[] args) {
        System.out.println(new 素性测试().divisor(100));
        System.out.println(new 素性测试().isPrime(100));
        System.out.println(new 素性测试().primeFactor(100));
        System.out.println(new 素性测试().sieve(100));
        System.out.println(new 素性测试().segmentSieve(10, 100));
    }

    //素性测试
    //还有费马测试、p算法、数域筛法
    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return n != 1;//1除外
    }

    //约数枚举
    public List<Integer> divisor(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n / i) res.add(n / i);
            }
        }
        return res;
    }

    //整数分解
    public Map<Integer, Integer> primeFactor(int n) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                res.put(i, res.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n != 1) res.put(n, 1);
        return res;
    }

    //埃氏筛法，返回n以内的素数个数
    public int sieve(int n) {
        int[] prime = new int[n];
        boolean[] isPrime = new boolean[n + 1];
        int p = 0;
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                prime[p++] = i;
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return p;
    }

    //区间筛法，求区间[a,b)的素数个数
    public int segmentSieve(int a, int b) {
        boolean[] isPrimeSmall = new boolean[b];
        boolean[] isPrime = new boolean[b];
        for (int i = 0; i * i < b; i++) {
            isPrimeSmall[i] = true;
        }
        for (int i = 0; i < b - a; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < b; i++) {
            if (isPrimeSmall[i]) {
                for (int j = 2 * i; j * j < b; j += i) {
                    isPrimeSmall[j] = false;//筛[2,根号b)
                }
                for (int j = Math.max(2, ((a + i - 1) / i) * i); j < b; j += i) {
                    isPrime[j - a] = false;//筛[a,b)
                }
            }
        }
        int res = 0;
        for (int i = 0; i < b; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }
}
