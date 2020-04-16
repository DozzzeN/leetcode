package Offer;

//https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ŀ����
//ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
//ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
//���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
//��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
public class flip_word_order_column {
    public static void main(String[] args) {
        System.out.println(new flip_word_order_column.Solution().ReverseSentence(
                " "
        ));
        System.out.println(new flip_word_order_column.Solution().ReverseSentence02(
                "student. a am I"
        ));
    }

    public static class Solution {
        //�Ȱ��ո��ַ����и���ַ������飬���ַ������鷴תƴ�����
        public String ReverseSentence(String str) {
            if (str == null || str.length() == 0) return "";
            String[] array = str.split(" ");
            //�� �������
            if (array.length == 0) return str;
            StringBuilder result = new StringBuilder();
            for (int i = array.length - 1; i >= 0; i--) {
                result.append(array[i]).append(" ");
            }
            result.deleteCharAt(result.length() - 1);
            return result.toString();
        }

        //�����ö���Ŀռ䣬��תÿ�����ʺ�ת�����ַ���
        public String ReverseSentence02(String str) {
            char[] chars = str.toCharArray();
            int i = 0, j = 0;
            while (j <= str.length()) {
                if (j == str.length() || chars[j] == ' ') {
                    reverse(chars, i, j - 1);
                    i = j + 1;
                }
                j++;
            }
            reverse(chars, 0, str.length() - 1);
            return new String(chars);
        }

        private void reverse(char[] c, int i, int j) {
            while (i < j)
                swap(c, i++, j--);
        }

        private void swap(char[] c, int i, int j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
    }
}
