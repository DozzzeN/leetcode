package BackTracking;

import java.util.ArrayList;
import java.util.List;

//22
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//例如，给出 n = 3，生成结果为：
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
public class generate_parentheses {
    public static void main(String[] args) {
        System.out.println(new generate_parentheses.Solution().generateParenthesis(3));
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n != 0) {
                generateParenthesis(result, n, "", 0, 0);
            }
            return result;
        }

        public void generateParenthesis(List<String> result, int n, String sample, int leftNum, int rightNum) {
            if (sample.length() == 2 * n) {
                result.add(sample);
                return;
            }
            if (leftNum < n) {
                generateParenthesis(result, n, sample + "(", leftNum + 1, rightNum);
            }
            if (leftNum > rightNum) {
                generateParenthesis(result, n, sample + ")", leftNum, rightNum + 1);
            }
        }

        //错误的解法，因为如果第一个if成立，改变了sample，对第二个if有影响
        public void generateParenthesisError(List<String> result, int n, String sample, int leftNum, int rightNum) {
            if (sample.length() == 2 * n) {
                result.add(sample);
                return;
            }
            if (leftNum < n) {
                sample += "(";
                generateParenthesisError(result, n, sample, leftNum + 1, rightNum);
            }
            if (leftNum > rightNum) {
                sample += ")";
                generateParenthesisError(result, n, sample, leftNum, rightNum + 1);
            }
        }
    }
}
