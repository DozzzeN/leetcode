package Graph;

import java.util.ArrayList;
import java.util.List;

//133
//����������ͨͼ��һ���ڵ�����ã����ظ�ͼ���������¡����ͼ�е�ÿ���ڵ㶼��������ֵ val��Int�� �����ھӵ��б�list[Node]����
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class clone_graph {
    public static void main(String[] args) {
    }
}
