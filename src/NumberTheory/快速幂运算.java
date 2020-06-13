package NumberTheory;

public class 快速幂运算 {
    public int modPow(int x, int n, int mod) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            n >>= 1;//n平方
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 快速幂运算().modPow(2, 10, 1));
    }
}
