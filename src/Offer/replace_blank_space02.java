package Offer;

//https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
public class replace_blank_space02 {
    public static void main(String[] args) {
        System.out.println(new replace_blank_space02.Solution().replaceSpace(new StringBuffer()));
    }

    //�����ַ���β����������ַ���ʹ���ַ����ĳ��ȵ����滻֮��ĳ��ȡ���Ϊһ���ո�Ҫ�滻�������ַ���%20����
    //���Ե�������һ���ո�ʱ����Ҫ��β��������������ַ���
    //����P1ָ���ַ���ԭ����ĩβλ�ã�P2ָ���ַ������ڵ�ĩβλ�á�P1��P2�Ӻ���ǰ��������P1������һ���ո�ʱ��
    //����Ҫ��P2ָ���λ���������02%��ע��������ģ�������������P1ָ���ַ���ֵ��
    //�Ӻ���ǰ����Ϊ���ڸı�P2��ָ�������ʱ������Ӱ�쵽P1����ԭ���ַ��������ݡ�
    //�۵�P2����P1ʱ��P2<=P1�������߱���������P1<0�����˳���
    public static class Solution {
        public String replaceSpace(StringBuffer str) {
            int P1 = str.length() - 1;
            for (int i = 0; i <= P1; i++)
                if (str.charAt(i) == ' ')
                    str.append("  ");

            int P2 = str.length() - 1;
            while (P1 >= 0 && P2 > P1) {
                char c = str.charAt(P1--);
                if (c == ' ') {
                    str.setCharAt(P2--, '0');
                    str.setCharAt(P2--, '2');
                    str.setCharAt(P2--, '%');
                } else {
                    str.setCharAt(P2--, c);
                }
            }
            return str.toString();
        }
    }
}
