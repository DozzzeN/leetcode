package NumberTheory;

public class ���������� {
    public int modPow(int x, int n, int mod) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            n >>= 1;//nƽ��
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ����������().modPow(2, 10, 1));
    }
}
