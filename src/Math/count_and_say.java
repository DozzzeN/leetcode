package Math;

//38
//����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 ������  "one 1"  ("һ��һ") , �� 11��
//11 ������ "two 1s" ("����һ"��, �� 21��
//21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��
//����һ�������� n��1 �� n �� 30��������������еĵ� n �
//ע�⣺����˳�򽫱�ʾΪһ���ַ�����
//ʾ�� 1:
//����: 1
//���: "1"
//ʾ�� 2:
//����: 4
//���: "1211"
public class count_and_say {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(36));
    }

    static class Solution {
        public String countAndSay(int n) {
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder("1");
            for (int i = 0; i < n - 1; i++) {
                int count = 1;
                for (int j = 0; j < temp.length(); j++) {
                    //�ظ����֣���¼�ظ�����count�������м���
                    if (temp.length() > j + 1 && temp.charAt(j) == temp.charAt(j + 1)) {
                        count++;
                    } else {
                        //���м�����������count
                        result.append(count).append(temp.charAt(j));
                        count = 1;
                    }
                }
                temp = result;
                result = new StringBuilder();
            }
            return temp.toString();
        }
    }
}
