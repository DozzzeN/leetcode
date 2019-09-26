package BackTracking;

import java.util.ArrayList;
import java.util.List;

//22
//���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
//���磬���� n = 3�����ɽ��Ϊ��
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

        //����Ľⷨ����Ϊ�����һ��if�������ı���sample���Եڶ���if��Ӱ��
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
