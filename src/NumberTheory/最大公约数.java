package NumberTheory;

public class 最大公约数 {
    public static void main(String[] args) {
        System.out.println(new 最大公约数().gcd(4, 8));
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
