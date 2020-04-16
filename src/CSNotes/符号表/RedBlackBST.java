package CSNotes.���ű�;

/**
 * �������2-3����������������Ҫ�ֱ���2-�ڵ��3-�ڵ㣬��������ͨ�Ķ��������֮�ϣ�Ϊ�ڵ������ɫ��
 * ָ��һ���ڵ��������ɫ���Ϊ��ɫ����ô����ڵ���ϲ�ڵ��ʾ����һ��3-�ڵ㣬����ɫ������ͨ���ӡ�
 * <p>
 * ����������������ʣ�
 * �����Ӷ�Ϊ�����ӣ�
 * ������ɫƽ�⣬����������ӵ����ڵ��·���ϵĺ�����������ͬ��
 * �������ʱ���Խ������ӻ�ƽ��
 * <p>
 * һ�Ŵ�СΪN�ĺ�����ĸ߶Ȳ��ᳬ��2logN������������������Ӧ��2-3������������ߵ�·���ڵ�ȫ������3-�ڵ�����඼��2-�ڵ㡣
 * �����������Ĳ�������Ҫ��ʱ�䶼�Ƕ�������ġ�
 */
//      [AB]        B       //��ʾ������   �ȼ���   A = B
//     / | \      // \                         / \   \
//               A
//              / \
public class RedBlackBST<Key extends Comparable<Key>, Value> extends BST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * ��Ϊ�Ϸ��ĺ����Ӷ�Ϊ�����ӣ��������������Ϊ�����ӣ���ô����Ҫ��������ת������
     */
    //     A    ����    B
    //    / \\       // \
    //       B      A
    //      / \    / \
    //
    public Node rotateLeft(Node h) {
        Node x = h.right;//B
        h.right = x.left;//A��������
        x.left = h;//A��B��������
        x.color = h.color;
        h.color = RED;
        x.N = h.N;//B���ӽڵ���������֮ǰA���ӽڵ�����
        recalculateSize(h);
        return x;
    }

    /**
     * ��������ת��Ϊ��ת������������������ӣ������֮��Ĳ��������̽�֡�
     */
    //     B  ����   A
    //   // \      / \\
    //   A            B
    //  / \          / \
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        recalculateSize(h);
        return x;
    }

    /**
     * һ��4-�ڵ��ں�����б���Ϊһ���ڵ�������ӽڵ㶼�Ǻ�ɫ�ġ�
     * ����4-�ڵ������Ҫ���ӽڵ����ɫ�ɺ���֮�⣬ͬʱ��Ҫ�����ڵ����ɫ�ɺڱ�죬��2-3���ĽǶȿ����ǽ��м�ڵ��Ƶ��ϲ�ڵ㡣
     */
    //     |     | |
    //     B      B
    //   // \\   / \
    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * �Ƚ�һ���ڵ㰴����������ķ������뵽��ȷλ�ã�Ȼ���ٽ���������ɫ������
     * ������ӽڵ��Ǻ�ɫ�Ķ����ӽڵ��Ǻ�ɫ�ģ���������ת��
     * ������ӽڵ��Ǻ�ɫ�ģ��������ӽڵ�����ӽڵ�Ҳ�Ǻ�ɫ�ģ���������ת��
     * ��������ӽڵ��Ϊ��ɫ�ģ�������ɫת����
     * <p>
     * ���Կ����ò�������Ͷ���������Ĳ���������ƣ�ֻ��������������ת����ɫ�任�������ɡ�
     * ���ڵ�һ��Ϊ��ɫ����Ϊ���ڵ�û���ϲ�ڵ㣬Ҳ��û���ϲ�ڵ��������ָ����ڵ㡣
     * flipColors()�п��ܻ�ʹ�ø��ڵ����ɫ��Ϊ��ɫ��ÿ�����ڵ��ɺ�ɫ��ɺ�ɫʱ���ĺ����Ӹ߶ȼ� 1.
     */
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            Node node = new Node(key, value, 1);
            node.color = RED;
            return node;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            x.val = value;
        else if (cmp < 0)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);

        if (isRed(x.right) && !isRed(x.left))
            x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left))
            x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right))
            flipColors(x);

        recalculateSize(x);
        return x;
    }
}