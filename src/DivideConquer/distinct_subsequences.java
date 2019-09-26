package DivideConquer;

//115
//����һ���ַ��� S ��һ���ַ��� T�������� S ���������� T ���ֵĸ�����
//һ���ַ�����һ����������ָ��ͨ��ɾ��һЩ��Ҳ���Բ�ɾ�����ַ��Ҳ�����ʣ���ַ����λ������ɵ����ַ����������磬"ACE" �� "ABCDE" ��һ�������У��� "AEC" ���ǣ�
//ʾ�� 1:
//����: S = "rabbbit", T = "rabbit"
//���: 3
//����:
//����ͼ��ʾ, �� 3 �ֿ��Դ� S �еõ� "rabbit" �ķ�����
//(�ϼ�ͷ���� ^ ��ʾѡȡ����ĸ)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
public class distinct_subsequences {
    public static void main(String[] args) {
        System.out.println(new distinct_subsequences.Solution().numDistinct(
                "babgbag", "bag"
        ));
    }

    //�ݹ�֮���Σ����ݣ�
    static class Solution {
        public int numDistinct(String s, String t) {
            return numDistinct(s, 0, t, 0);
        }

        //��sStart��ʼ��s����ѡ���tStart��ʼ��t��
        public int numDistinct(String s, int sStart, String t, int tStart) {
            int count = 0;
            //t���Ѿ�����ĩβ��ѡ����1��
            if (tStart == t.length()) {
                return 1;
            }
            //s���Ѿ�����ĩβ��ѡ����0��
            if (sStart == s.length()) {
                return 0;
            }
            if (s.charAt(sStart) == t.charAt(tStart)) {
                //�ӵ�ǰsStartλ�õ�s����ѡ����ĸ�벻ѡ����ĸ
                count = numDistinct(s, sStart + 1, t, tStart + 1)
                        + numDistinct(s, sStart + 1, t, tStart);
            } else {
                count = numDistinct(s, sStart + 1, t, tStart);
            }
            return count;
        }
    }
}
