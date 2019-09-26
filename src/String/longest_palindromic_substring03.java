package String;

import java.util.ArrayList;
import java.util.List;

//5
//����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
//����: "babad"
//���: "bab"
//ע��: "aba" Ҳ��һ����Ч�𰸡�
public class longest_palindromic_substring03 {
    public static void main(String[] args) {
        String input = "abbc";
        System.out.println(new longest_palindromic_substring03.Solution().longestPalindrome(input));

    }

    //Manacher�㷨
    static class Solution {
        public String longestPalindrome(String s) {
            //��ԭ�ַ���תΪmanacher�ַ��� #b#a#b#a#d#
            List<Character> s_new = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                s_new.add('#');
                s_new.add(s.charAt(i));
            }
            s_new.add('#');
            List<Integer> Len = new ArrayList<>();//Len�������ʣ���S_new[i]Ϊ���ĵ�������Ӵ�����Ϊ2Len[i] - 1
            //Len[i]����iΪ���ĵ�����Ĵ������Ҷ��ַ�������ַ��ľ���
            //                                               ��          ��
            //��  S_new:        #  a  #  a  #  b  #  a  #  b  #  b  #  a  #
            //��Ӧ  Len         1  2  3  2  1  4  1  4  1  2  5  2  1  2  1
            //                                               ��
            String sub = "";//������Ӵ�
            int sub_midd = 0;//��ʾ��i֮ǰ���õ���Len�����е����ֵ����λ�ã�����Ĵ����ģ�sub_midd = Len.indexOf(Math.max(Len)
            int sub_side = 0;//��ʾ��sub_middΪ���ĵ�������Ӵ������Ҷ���S_new�е�λ�ã�����Ĵ����ұ߽磩sub_side = sub_midd + Len[sub_midd] - 1
            Len.add(1);
            for (int i = 1; i < s_new.size(); i++) {
                //sub_midd - (sub_side - sub_midd) = 2 * sub_midd - sub_side
                //S_new  2*sub_midd-sub_side | { j } | sub_midd | { i } | sub_side
                if (i < sub_side) { //i<sub_sideʱ����Len[j]��sub_side - i��ȡ��Сֵ��ʡȥ��j���ж�
                    int j = 2 * sub_midd - i;//j��i����sub_midd�ĶԳƵ�
                    if (j >= 2 * sub_midd - sub_side && Len.get(j) <= sub_side - i) {
                        //��S_new[j]Ϊ���ĵ�������Ӵ�������S_new[sub_midd]Ϊ���ĵ�������Ӵ����ڲ���������i��j����sub_midd�Գƣ���֪Len[i] = Len[j]
                        Len.add(Len.get(j));
                    } else
                        //S_new[i]Ϊ���ĵĻ��Ĵ��������쵽sub_side֮�⣬������sub_side�Ĳ��ֻ�û�н���ƥ�䣬����Ҫ��sub_side+1λ�ÿ�ʼ����ƥ��
                        //S_new  2*sub_midd-sub_side { | j | } sub_midd { | i | } sub_side
                        Len.add(sub_side - i + 1);
                } else
                    //��i > sub_sideʱ����˵����S_new[i]Ϊ���ĵ�������Ӵ���û��ʼƥ��Ѱ�ң������Ҫһ��һ������ƥ��Ѱ��
                    //���������sub_side�Ͷ�Ӧ��sub_midd�Լ�Len[i]
                    //�˴��Ļ��Ĵ��ұ߽�Ϊ1���������ַ�
                    Len.add(1);
                while ((i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i))))
                    //(i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()��ʾ��iΪ���ģ�һֱ���������ַ���
                    //s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i)��ʾԭ����iΪ���ĵĻ��Ĵ������ַ���ͬ��Len[i]ֵ��Ҫ����
                    Len.set(i, Len.get(i) + 1);//s_new[i]���˿�ʼ��չƥ�䣬ֱ��ƥ��ʧ��ʱֹͣ
                if (Len.get(i) >= Len.get(sub_midd)) {
                    //ƥ����»����Ӵ����ȴ���ԭ�еĳ���
                    sub_side = Len.get(i) + i - 1;
                    sub_midd = i;
                }
            }
            //��ӦS_new��[2 * sub_midd - sub_side , sub_side]
            sub = s.substring((2 * sub_midd - sub_side) / 2, sub_side / 2);//��s���ҵ�������Ӵ���λ��
            return sub;
        }
    }

}
