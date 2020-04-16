package Offer;

import java.util.LinkedList;
import java.util.Queue;

//https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
//���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
public class the_first_non_repeating_character_in_the_character_stream02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "helloworld";
        for (int i = 0; i < input.length(); i++) {
            solution.Insert(input.charAt(i));
        }
        System.out.println(solution.FirstAppearingOnce());
    }

    static public class Solution {
        private int[] counts = new int[256];
        private Queue<Character> queue = new LinkedList<>();

        public void Insert(char ch) {
            counts[ch]++;
            queue.add(ch);
            while (!queue.isEmpty() && counts[queue.peek()] > 1)
                queue.poll();
        }

        public char FirstAppearingOnce() {
            return queue.isEmpty() ? '#' : queue.peek();
        }
    }
}
