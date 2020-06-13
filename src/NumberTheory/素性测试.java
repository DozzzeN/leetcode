package NumberTheory;

import java.util.*;

public class ���Բ��� {
    public static void main(String[] args) {
        System.out.println(new ���Բ���().divisor(100));
        System.out.println(new ���Բ���().isPrime(100));
        System.out.println(new ���Բ���().primeFactor(100));
        System.out.println(new ���Բ���().sieve(100));
        System.out.println(new ���Բ���().segmentSieve(10, 100));
    }

    //���Բ���
    //���з�����ԡ�p�㷨������ɸ��
    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return n != 1;//1����
    }

    //Լ��ö��
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

    //�����ֽ�
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

    //����ɸ��������n���ڵ���������
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

    //����ɸ����������[a,b)����������
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
                    isPrimeSmall[j] = false;//ɸ[2,����b)
                }
                for (int j = Math.max(2, ((a + i - 1) / i) * i); j < b; j += i) {
                    isPrime[j - a] = false;//ɸ[a,b)
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
