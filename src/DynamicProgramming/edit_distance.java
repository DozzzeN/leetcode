package DynamicProgramming;

//72
//������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��
//����Զ�һ�����ʽ����������ֲ�����
//	����һ���ַ�
//	ɾ��һ���ַ�
//	�滻һ���ַ�
//ʾ�� 1:
//����: word1 = "horse", word2 = "ros"
//���: 3
//����:
//horse -> rorse (�� 'h' �滻Ϊ 'r')
//rorse -> rose (ɾ�� 'r')
//rose -> ros (ɾ�� 'e')
//ʾ�� 2:
//����: word1 = "intention", word2 = "execution"
//���: 5
//����:
//intention -> inention (ɾ�� 't')
//inention -> enention (�� 'i' �滻Ϊ 'e')
//enention -> exention (�� 'n' �滻Ϊ 'x')
//exention -> exection (�� 'n' �滻Ϊ 'c')
//exection -> execution (���� 'u')
public class edit_distance {
    public static void main(String[] args) {
        System.out.println(new edit_distance.Solution().minDistance("", "a"));
    }

    //D[i][j] ��ʾ word1 ��ǰ i ����ĸ�� word2 ��ǰ j ����ĸ֮��ı༭����
    //��������Ӵ������һ����ĸ��ͬ��word1[i] = word2[j] ������£�
    //D[i][j] = D[i - 1][j - 1]
    //����word1[i] != word2[j] ���ǽ������滻���һ���ַ�ʹ��������ͬ��
    //D[i][j] = 1 + min(D[i - 1][j], D[i][j - 1], D[i - 1][j - 1])
    static class Solution {
        public int minDistance(String word1, String word2) {
            int[][] D = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word1.length(); i++) {
                D[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                D[0][j] = j;
            }
            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        D[i + 1][j + 1] = D[i][j];
                    } else {
                        D[i + 1][j + 1] = 1 + Math.min(
                                Math.min(D[i][j + 1], D[i][j]), D[i + 1][j]
                        );
                    }
                }
            }
            return D[word1.length()][word2.length()];
        }
    }
}
