package CSNotes.���ű�;

import java.util.ArrayList;
import java.util.List;

/**
 * ���������
 * ��������һ�������ӣ�������һ���������������ӵĽڵ㣬ÿ�����Ӷ�ָ��һ���Ӷ�������
 * �����������BST����һ�Ŷ�����������ÿ���ڵ��ֵ�����ڵ������������е����нڵ��ֵ��С�ڵ��������������нڵ��ֵ��
 * BST��һ����Ҫ���ʣ���������������������������
 * <p>
 * ������������㷨����ʱ��ȡ����������״����������״��ȡ���ڼ���������Ⱥ�˳��
 * ��õ������������ȫƽ��ģ�ÿ�������Ӻ͸��ڵ�ľ��붼Ϊ logN��
 * ���������£����ĸ߶�Ϊ N��
 */
public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    protected Node root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    protected void recalculateSize(Node x) {
        x.N = size(x.left) + size(x.right) + 1;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * ������ǿյģ������δ���У�
     * ��������ҵļ��͸��ڵ�ļ���ȣ��������У�
     * ����ݹ���������в��ң���������ҵļ���С�����������в��ң��ϴ�����������в��ҡ�
     */
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp < 0) return get(x.left, key);
        else return get(x.right, key);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * ������ļ������������У���Ҫ����һ���½ڵ㣬���Ҹ����ϲ�ڵ������ָ��ýڵ㣬ʹ�øýڵ���ȷ�����ӵ����С�
     */
    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp == 0) x.val = value;
        else if (cmp < 0) x.left = put(x.left, key, value);
        else x.right = put(x.right, key, value);
        recalculateSize(x);
        return x;
    }

    /**
     * floor(key)��С�ڵ��ڼ�������
     * �����С�ڸ��ڵ�ļ�����ôfloor(key) һ�����������У�
     * ��������ڸ��ڵ�ļ�����Ҫ���ж����������Ƿ����floor(key)��������ھͷ��أ�������ڵ����floor(key)��
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    /**
     * rank(key) ���� key��������
     * ������͸��ڵ�ļ���ȣ������������Ľڵ�����
     * ���С�ڣ��ݹ�������������е�������
     * ������ڣ��ݹ�������������е������������������Ľڵ������ټ���1�����ڵ㣩��
     */
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return size(x.left);
        else if (cmp < 0) return rank(key, x.left);
        else return 1 + size(x.left) + rank(key, x.right);
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node min(Node x) {
        if (x == null) return null;
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node max(Node x) {
        if (x == null) return null;
        if (x.right == null) return x;
        return max(x.right);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * ��ָ����С�ڵ������ָ����С�ڵ����������
     * D   ɾ��A   D
     * / \        / \
     * C  E       C  E
     * /    \     /    \
     * A     F    B     F
     * \
     * B
     */
    public Node deleteMin(Node x) {
        //x.right����Ϊnull
        if (x.left == null) return x.right;
        //�ݹ��ҵ���С�Ľڵ㣨x������������
        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * �����ɾ���Ľڵ�ֻ��һ����������ôֻ��Ҫ��ָ���ɾ���ڵ������ָ��Ψһ���������ɣ�
     * ����������������С�ڵ��滻�ýڵ㡣
     * F        ɾ��B        F
     * / \                  / \
     * B  G                 C  G
     * / \  \               / \  \
     * A  E  H              A  E  H
     * /                    /
     * C                    D
     * \
     * D
     */
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);//λ��x��������
        else if (cmp > 0) x.right = delete(x.right, key);//λ��x��������
        else {//ɾ��x��ͼ�е�B��
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);//ͼ�е�C�ŵ���ǰB��λ��
            x.right = deleteMin(t.right);//ɾ��ԭ��ͼ�е�C
            x.left = t.left;//����������
        }
        recalculateSize(x);
        return x;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    /**
     * ���ö����������������Ľ��Ϊ�������ص㡣
     */
    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if (x == null) return list;
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if (cmpL < 0) list.addAll(keys(x.left, l, h));
        if (cmpL <= 0 && cmpH >= 0) list.add(x.key);
        if (cmpH > 0) list.addAll(keys(x.right, l, h));
        return list;
    }

    protected class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        //�Ըýڵ�Ϊ���������ڵ�����
        int N;
        //�������ʹ��
        boolean color;

        Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
}