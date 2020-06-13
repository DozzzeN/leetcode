package Tree;

public class BinarySearchTree {
    Node insert(Node p, int x) {
        if (p == null) {
            Node q = new Node();
            q.val = x;
            q.right = null;
            q.left = q.right;
            return q;
        } else {
            if (x < p.val) p.left = insert(p.left, x);
            else p.right = insert(p.right, x);
            return p;
        }
    }

    boolean find(Node p, int x) {
        if (p == null) return false;
        else if (x == p.val) return true;
        else if (x < p.val) return find(p.left, x);
        else return find(p.right, x);
    }

    //��Ҫɾ���Ľڵ�û������ӣ���ô�Ͱ��Ҷ�������ȥ��
    //��Ҫɾ���Ľڵ�������û���Ҷ��ӣ���ô�Ͱ����������ȥ��
    //�������������������Ļ����Ͱ�����ӵ����������Ľڵ��ᵽ��Ҫɾ���Ľڵ��ϡ�
    Node remove(Node p, int x) {
        if (p == null) return null;
        else if (x < p.val) p.left = remove(p.left, x);
        else if (x > p.val) p.right = remove(p.right, x);
        else if (p.left == null) {
            return p.right;
        } else if (p.left.right == null) {
            Node q = p.left;
            q.right = p.right;
            return q;
        } else {
            Node q;
            for (q = p.left; q.right.right != null; q = q.right) ;
            Node r = q.right;
            q.right = r.left;
            r.left = p.left;
            r.right = p.right;
            return r;
        }
        return p;
    }

    public static class Node {
        int val;
        Node left, right;
    }
}
