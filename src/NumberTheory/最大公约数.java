package NumberTheory;

public class ���Լ�� {
    public static void main(String[] args) {
        System.out.println(new ���Լ��().gcd(4, 8));
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
