package Offer;

//https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
//����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
//��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
//NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
public class rotate_the_smallest_number_of_an_array {
    public static void main(String[] args) {
        System.out.println(new rotate_the_smallest_number_of_an_array.Solution().minNumberInRotateArray(
                new int[]{1, 0, 1, 1, 1}
        ));
        System.out.println(new rotate_the_smallest_number_of_an_array.Solution().minNumberInRotateArray2(
                new int[]{1, 0, 1, 1, 1}
        ));
    }

    public static class Solution {
        public int minNumberInRotateArray(int[] array) {
            if (array == null || array.length == 0) return 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    return array[i];
                }
            }
            return array[0];
        }

        //���ַ�
        //����ת����԰�ֿ��Եõ�һ��������СԪ�ص�����ת���飬�Լ�һ���ǵݼ���������顣
        //�µ���ת���������Ԫ����ԭ�����һ�룬
        //�Ӷ��������ģ������һ�룬�����۰����ʵ��㷨��ʱ�临�Ӷ�ΪO(logN)��
        public int minNumberInRotateArray2(int[] array) {
            if (array == null || array.length == 0) return 0;
            int left = 0, right = array.length - 1, mid;
            while (left < right) {
                //����������ǵݼ�����
                if (array[left] < array[right])
                    return array[left];
                mid = (left + right) >>> 1;
                if (array[mid] > array[left]) {
                    left = mid + 1;
                } else if (array[right] > array[mid]) {
                    right = mid;
                } else {
                    left++;
                }
            }
            return array[left];
        }
    }
}
