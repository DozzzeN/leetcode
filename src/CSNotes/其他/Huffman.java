package CSNotes.����;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * �������ݳ��ֵ�Ƶ�ʶ����ݽ��б��룬�Ӷ�ѹ��ԭʼ���ݡ�
 * �������һ���ı��ļ������и����ַ����ֵĴ������£�
 * a:10
 * b:20
 * c:40
 * d:80
 * ���Խ�ÿ���ַ�ת���ɶ����Ʊ��룬���罫aת��Ϊ00��bת��Ϊ01��cת��Ϊ10��dת��Ϊ11��
 * ������򵥵�һ�ֱ��뷽ʽ��û�п��Ǹ����ַ���Ȩֵ������Ƶ�ʣ���
 * �����������������̰�Ĳ��ԣ�ʹ����Ƶ����ߵ��ַ��ı�����̣��Ӷ���֤����ı��볤����̡�
 * ��������һ�Ź���������ÿ�����ɹ�����ѡȡƵ�����ٵ������ڵ㣬����һ���½ڵ���Ϊ���ǵĸ��ڵ㣬
 * �����½ڵ��Ƶ��Ϊ�����ڵ�ĺ͡�ѡȡƵ�����ٵ�ԭ���ǣ����ɹ���ʹ����ѡȡ�Ľڵ�λ�����ĸ��Ͳ㣬
 * ��ô��Ҫ�ı��볤�ȸ�����Ƶ�ʸ��ٿ���ʹ���ܱ��볤�ȸ��١�
 * ���ɱ���ʱ���Ӹ��ڵ�����������������Ӷ�����λ0����������Ӷ�����λ1��
 * ֱ��������Ҷ�ӽڵ㣬Ҷ�ӽڵ������ַ��ı���������·�����롣
 */
public class Huffman {
    public static void main(String[] args) {
        Map<Character, Integer> frequencyForChar = new HashMap<>();
        frequencyForChar.put('a', 10);
        frequencyForChar.put('b', 20);
        frequencyForChar.put('c', 40);
        frequencyForChar.put('d', 80);
        Huffman huffman = new Huffman();
        System.out.println(huffman.encode(frequencyForChar));
    }

    public Map<Character, String> encode(Map<Character, Integer> frequencyForChar) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Character c : frequencyForChar.keySet()) {
            priorityQueue.add(new Node(c, frequencyForChar.get(c)));
        }
        while (priorityQueue.size() != 1) {
            Node node1 = priorityQueue.poll();//a-10
            Node node2 = priorityQueue.poll();//b-20
            priorityQueue.add(new Node(node1, node2, node1.freq + node2.freq));//0-30
        }
        return encode(priorityQueue.poll());
    }

    private Map<Character, String> encode(Node root) {
        Map<Character, String> encodingForChar = new HashMap<>();
        encode(root, "", encodingForChar);
        return encodingForChar;
    }

    private void encode(Node node, String encoding, Map<Character, String> encodingForChar) {
        if (node.isLeaf) {
            encodingForChar.put(node.ch, encoding);
            return;
        }
        encode(node.left, encoding + '0', encodingForChar);
        encode(node.right, encoding + '1', encodingForChar);
    }

    private class Node implements Comparable<Node> {
        char ch;
        int freq;
        boolean isLeaf;
        Node left, right;

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            isLeaf = true;
        }

        public Node(Node left, Node right, int freq) {
            this.left = left;
            this.right = right;
            this.freq = freq;
            isLeaf = false;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }
}
