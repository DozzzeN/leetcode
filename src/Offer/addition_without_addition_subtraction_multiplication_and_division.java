package Offer;

//https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
public class addition_without_addition_subtraction_multiplication_and_division {
    public static void main(String[] args) {
        System.out.println(new addition_without_addition_subtraction_multiplication_and_division.Solution().Add(3, -1));
    }

    public static class Solution {
        //������д��
        public int Add(int num1, int num2) {
            int count, carry;
            do {
                count = num1 ^ num2;//����λ�ĺ�
                carry = (num1 & num2) << 1;//��λ
                num1 = count;
                num2 = carry;
            } while (carry != 0);//ֱ����������λ
            return count;
        }

        //�ݹ��д��
        //a^b��ʾû�п��ǽ�λ������������ĺͣ�(a&b)<<1���ǽ�λ��
        //�ݹ����ֹ��ԭ����(a&b)<<1���ұ߻��һ��0����ô�����ݹ飬��λ���ұߵ�0���������࣬����λ���Ϊ0���ݹ���ֹ��
        public int Add02(int a, int b) {
            return b == 0 ? a : Add02(a ^ b, (a & b) << 1);
        }
    }
}
