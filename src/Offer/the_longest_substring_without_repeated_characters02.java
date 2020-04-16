package Offer;

import java.util.Arrays;

//����һ���ַ�����ֻ����a~z���ַ���������������ظ��ַ������ַ����ĳ��ȡ�
//�������arabcacfr��������ظ��ַ������ַ���Ϊacfr������Ϊ4��
public class the_longest_substring_without_repeated_characters02 {
    public static void main(String[] args) {
        System.out.println(new the_longest_substring_without_repeated_characters02().longestSubStringWithoutDuplication(
                "arabcacfr"
        ));
    }

    //��˫ָ��i,j�ֱ�ָ���һ�ڶ���Ԫ�أ���j�������ظ�Ԫ�أ����i����һλ��ʼ����
    public int longestSubStringWithoutDuplication(String str) {
        int[] preIndex = new int[26];//�����ַ����ֵ���һ�ε�����λ��
        Arrays.fill(preIndex, -1);
        int maxlen = 0, start = -1;
        for (int i = 0; i < str.length(); i++) {
            //s[i]�ַ��ϴγ��ֵ��±��Ƿ���start֮�����ǣ����ظ��ˣ����޸�startΪ��һ��s[i]��λ�ã�������һλ��ʼ����
            if (preIndex[str.charAt(i)] > start)
                start = preIndex[str.charAt(i)];
            preIndex[str.charAt(i)] = i;
            maxlen = Math.max(maxlen, i - start);
        }
        return maxlen;
    }
}
