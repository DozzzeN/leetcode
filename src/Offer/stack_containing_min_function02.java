package Offer;

//https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

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
            //minStack保存了当前元素入栈时，此时最小的元素
            //若min是当前元素，在pop时两个栈同时pop即可
            //若min不是当前元素，是之前入栈的元素，minStack则不记录任何当前元素信息，
            //只记录当前的最小元素，pop时删除此时的最小元素（实际上是最小元素的冗余备份），不影响再次min
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
