package Offer;

//https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ŀ����
//�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
//����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
//Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
public class left_rotation_string {
    public static void main(String[] args) {
        System.out.println(new left_rotation_string.Solution().LeftRotateString(
                "abcdefghi", 3
        ));
    }

    //XΪstrǰnλ��YΪstrʣ�µģ�strԭ����X||Y������Ҫ��Y||X
    //��X�ķ�תΪX'��Y�ķ�תΪY'
    //Y||X=(X'||Y')'
    public static class Solution {
        public String LeftRotateString(String str, int n) {
            if (str == null || str.length() == 0 || n > str.length()) return "";
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < n / 2; i++) {
                char c = sb.charAt(i);
                sb.replace(i, i + 1, str.charAt(n - i - 1) + "");
                sb.replace(n - i - 1, n - i, c + "");
            }
            for (int i = 0; i < (str.length() - n) / 2; i++) {
                char c = sb.charAt(i + n);
                sb.replace(i + n, i + n + 1, str.charAt(str.length() - i - 1) + "");
                sb.replace(str.length() - i - 1, str.length() - i, c + "");
            }
            return sb.reverse().toString();
        }
    }
}
