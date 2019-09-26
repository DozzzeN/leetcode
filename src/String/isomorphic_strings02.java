package String;

//205
//���������ַ��� s �� t���ж������Ƿ���ͬ���ġ�
//��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ�
//���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
public class isomorphic_strings02 {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(new Solution().isIsomorphic(s, t));

    }

    //��¼һ���ַ��ϴγ��ֵ�λ�ã���������ַ����е��ַ��ϴγ��ֵ�λ��һ������ô������ͬ����
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] sNum = new int[256];
            int[] tNum = new int[256];
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i), tc = t.charAt(i);
                if (sNum[sc] != tNum[tc]) {
                    return false;
                }
                sNum[sc] = i + 1;
                tNum[tc] = i + 1;
            }

            return true;

        }
    }
}
