package Offer;

//https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������

import java.util.Stack;

public class stack_containing_min_function02 {
    public static void main(String[] args) {
        stack_containing_min_function02.Solution solution = new Solution();
        solution.push(1);
        System.out.println(solution.top());
        System.out.println(solution.min());
        solution.push(3);
        System.out.println(solution.top());
        System.out.println(solution.min());
        solution.push(2);
        System.out.println(solution.top());
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.top());
        System.out.println(solution.min());
    }

    public static class Solution {
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            dataStack.push(node);
            //minStack�����˵�ǰԪ����ջʱ����ʱ��С��Ԫ��
            //��min�ǵ�ǰԪ�أ���popʱ����ջͬʱpop����
            //��min���ǵ�ǰԪ�أ���֮ǰ��ջ��Ԫ�أ�minStack�򲻼�¼�κε�ǰԪ����Ϣ��
            //ֻ��¼��ǰ����СԪ�أ�popʱɾ����ʱ����СԪ�أ�ʵ��������СԪ�ص����౸�ݣ�����Ӱ���ٴ�min
            minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
