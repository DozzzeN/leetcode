package Offer;

//https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
//ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
//�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
public class regular_expression_matching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.match(
                new char[]{'a'},
                new char[]{'.', '*'}));
    }

    //�������� "a" ".*"
    //"" "."
    static public class Solution {
        public boolean match(char[] str, char[] pattern) {
            return matchHelper(str, 0, pattern, 0);
        }

        public boolean matchHelper(char[] str, int i, char[] pattern, int j) {
            if (i == str.length && j == pattern.length) return true;
            if (j >= pattern.length) return false;
            if (j + 1 == pattern.length || (j + 1 < pattern.length && pattern[j + 1] != '*')) {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {
                    return matchHelper(str, i + 1, pattern, j + 1);
                } else return false;
            } else {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {//�Ǻ�ƥ��0�λ�һ��
                    return matchHelper(str, i, pattern, j + 2) || matchHelper(str, i + 1, pattern, j);
                } else return matchHelper(str, i, pattern, j + 2);
            }
        }
    }
}
