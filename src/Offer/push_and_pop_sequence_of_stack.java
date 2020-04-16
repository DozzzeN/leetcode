package Offer;

import java.util.Stack;

//https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
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
