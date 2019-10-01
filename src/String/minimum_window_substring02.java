package String;

//76
//����һ���ַ��� S��һ���ַ��� T�������ַ��� S �����ҳ������� T ������ĸ����С�Ӵ���
//ʾ����
//����: S = "ADOBECODEBANC", T = "ABC"
//���: "BANC"
//˵����
//	��� S �в����������Ӵ����򷵻ؿ��ַ��� ""��
//	��� S �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
public class minimum_window_substring02 {
    public static void main(String[] args) {
        System.out.println(new minimum_window_substring02.Solution().minWindow("ADOBECODEBANC",
                "ABC"));
    }

    //��ϣ��
    //����˫ָ�룬��̬ά��һ�����䡣βָ�벻������ɨ����ɨ��һ�����ڰ���������T���ַ���������ͷָ�룬ֱ����������Ϊֹ
    //����ǵ�ǰ����С���ڡ�����¼������С���ڵ�ֵ������ѡ����С��һ��
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0) return "";
            if (t == null || s.length() < t.length()) return "";
            int[] appearCount = new int[256];
            int[] expectCount = new int[256];
            for (int i = 0; i < t.length(); i++) {
                expectCount[t.charAt(i)]++;
            }
            int minV = Integer.MAX_VALUE;
            int minStart = 0;
            int widStart = 0;
            int appeared = 0;
            for (int widEnd = 0; widEnd < s.length(); widEnd++) {
                if (expectCount[s.charAt(widEnd)] > 0) {
                    appearCount[s.charAt(widEnd)]++;
                    //ͳ��S�г���T���ַ��ĸ���appeared
                    if (appearCount[s.charAt(widEnd)] <= expectCount[s.charAt(widEnd)]) appeared++;
                }
                if (appeared == t.length()) {
                    //����ͷָ�룬ֱ������������
                    //����һ��S�г���T���ַ�������T���ַ��ࣻ��������T��δ����S���ַ�
                    while (appearCount[s.charAt(widStart)] > expectCount[s.charAt(widStart)]
                            || expectCount[s.charAt(widStart)] == 0) {
                        appearCount[s.charAt(widStart)]--;
                        widStart++;
                    }
                    //��¼���ڳ��ȣ����ͷָ�봦Ϊ���ڵ����λ��
                    if (minV > (widEnd - widStart + 1)) {
                        minV = widEnd - widStart + 1;
                        minStart = widStart;
                    }
                }
            }
            if (minV == Integer.MAX_VALUE) return "";
            return s.substring(minStart, minV + minStart);
        }
    }
}

