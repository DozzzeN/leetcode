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
    }
}
