package Offer;

import java.util.Stack;

//https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
public class push_and_pop_sequence_of_stack {
    public static void main(String[] args) {
        System.out.println(new push_and_pop_sequence_of_stack.Solution().IsPopOrder(
                new int[]{1, 2, 3, 4, 5},
//                new int[]{4, 5, 3, 2, 1}
                new int[]{4, 3, 5, 1, 2}
//                new int[]{3, 5, 4, 2, 1}
        ));
    }

    public static class Solution {
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            if (popA.length == 0 || popA.length != pushA.length) return false;
            Stack<Integer> stack = new Stack<>();
            for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
                stack.push(pushA[pushIndex]);
                while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                    stack.pop();
                    popIndex++;
                }
            }
            return stack.isEmpty();
        }
    }
}
