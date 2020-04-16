package CSNotes.����;

/**
 * ���������ӣ��ֱ�Ϊfrom��buffer��to����Ҫ��from�ϵ�Բ��ȫ���ƶ���to�ϣ�����Ҫ��֤СԲ��ʼ���ڴ�Բ���ϡ�
 * ����һ������ĵݹ����⣬��Ϊ������⣺
 * �ٽ�n-1��Բ�̴�from->buffer
 * �ڽ�1��Բ�̴�from->to
 * �۽�n-1��Բ�̴�buffer->to
 * ���ֻ��һ��Բ�̣���ôֻ��Ҫ����һ���ƶ�������
 * ����������ۿ���֪����a(n)=2*a(n-1)+1����Ȼa(n)=2^n-1��n��Բ����Ҫ�ƶ�2^n-1�Ρ�
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
