package Offer;

import java.util.Arrays;

//����һ���ַ�����ֻ����a~z���ַ���������������ظ��ַ������ַ����ĳ��ȡ�
//�������arabcacfr��������ظ��ַ������ַ���Ϊacfr������Ϊ4��
public class the_longest_substring_without_repeated_characters {
    public static void main(String[] args) {
        System.out.println(new the_longest_substring_without_repeated_characters().longestSubStringWithoutDuplication(
                "arabcacfr"
        ));
    }

    //��̬�滮����f(i)��ʾ��i���ַ�[��β]�������ظ����ַ���������ȣ���������ɨ��
    //1������i���ַ���֮ǰû���ֹ�����f(i)=f(i-1)+1;
    //2������i���ַ���֮ǰ���ֹ���
    //�����i���ַ������ϴγ���֮��ľ���Ϊd
    //(a)��d<=f(i-1)����˵����i���ַ��ϴγ�����f(i-1)��Ӧ�Ĳ��ظ��ַ���֮�ڣ���ô��ʱ�����f(i)=d
    //(b)��d>f(i-1)������Ӱ�죬f(i)=f(i-1)+1
    //����arabcacfr
    //f(0)=1��a
    //f(1)=2��ar
    //f(2)=2��ra����Ϊd=2��f(1)=2��������һ��a��f(1)֮��
    //f(3)=3��rab
    //f(4)=4��rabc
    //f(5)=3��bca����Ϊd=3��f(4)=4��������һ��aһ����f(4)��
    //f(6)=2��ac
    //f(7)=3��acf
    //f(8)=4��acfr����Ϊd=7��f(7)=3�������һ��r����f(7)�У�f(8)=f(7)+1
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndex = new int[26];//�����ַ����ֵ���һ�ε�����λ��
        Arrays.fill(preIndex, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndex[c];
            if (preI == -1 || curI - preI > curLen) {//û���ֹ�������d>f(i-1)
                curLen++;
            } else {//���ֹ�
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;//f(i)=d
            }
            preIndex[c] = curI;
        }
        return Math.max(maxLen, curLen);
    }
}
