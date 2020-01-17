package Offer;

//https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class stack_containing_min_function {
    public static void main(String[] args) {
        stack_containing_min_function.Solution solution = new Solution();
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
        private Stack<Integer> stack = new Stack<>();
        private ArrayList<Integer> list = new ArrayList<>();

        public void push(int node) {
            stack.push(node);
            list.add(node);
            Collections.sort(list);
        }

        public void pop() {
            if (stack.empty()) return;
            int del = 0;
            for (int i = 0; i < list.size(); i++) {
                if (stack.peek().equals(list.get(i))) {
                    del = i;
                }
            }
            list.remove(del);
            Collections.sort(list);
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return list.get(0);
        }
    }
}
