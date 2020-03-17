package Offer;

import java.util.Stack;

//https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class implementing_a_queue_with_two_stacks {
    public static void main(String[] args) {
        implementing_a_queue_with_two_stacks.Solution solution = new implementing_a_queue_with_two_stacks.Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }

    public static class Solution {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
