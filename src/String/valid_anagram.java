package String;

//242
//���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
//����: s = "rat", t = "car"
//���: false
//����: s = "anagram", t = "nagaram"
//���: true
public class valid_anagram {
    public static void main(String[] args) {
        valid_anagram.Solution solution = new valid_anagram.Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] cnts = new int[26];//Сд��ĸ26��
            for (char c : s.toCharArray()) {
                cnts[c - 'a']++;//Сд��ĸת�����֣���Ӧcnts����֮�е�ĳһλ
            }
            for (char c : t.toCharArray()) {
                cnts[c - 'a']--;//�����ظ���ĸ��cnts�����е�ֵΪ0
            }
            for (int cnt : cnts) {
                if (cnt != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
