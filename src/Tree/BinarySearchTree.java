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

    //需要删除的节点没有左儿子，那么就把右儿子提上去。
    //需要删除的节点的左儿子没有右儿子，那么就把左儿子提上去。
    //以上两种情况都不满足的话，就把左儿子的子孙中最大的节点提到需要删除的节点上。
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
