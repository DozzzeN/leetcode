package CSNotes.其他;

/**
 * 有三个柱子，分别为from、buffer、to。需要将from上的圆盘全部移动到to上，并且要保证小圆盘始终在大圆盘上。
 * 这是一个经典的递归问题，分为三步求解：
 * ①将n-1个圆盘从from->buffer
 * ②将1个圆盘从from->to
 * ③将n-1个圆盘从buffer->to
 * 如果只有一个圆盘，那么只需要进行一次移动操作。
 * 从上面的讨论可以知道，a(n)=2*a(n-1)+1，显然a(n)=2^n-1，n个圆盘需要移动2^n-1次。
 */
public class Hanoi {
    public static void move(int n, String from, String buffer, String to) {
        if (n == 1) {
            System.out.println("from " + from + " to " + to);
            return;
        }
        move(n - 1, from, to, buffer);
        move(1, from, buffer, to);
        move(n - 1, buffer, from, to);
    }

    public static void main(String[] args) {
        Hanoi.move(3, "H1", "H2", "H3");
    }
}
