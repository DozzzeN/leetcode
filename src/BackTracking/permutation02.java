package BackTracking;

import java.util.Arrays;

//46
//����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�
//ʾ��:
//����: [1,2,3]
//���:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class permutation02 {
    //s��ʾ����array[start]������ݽ���ȫ����
    public static void permute(int[] array, int start) {
        if (start == array.length) {  // ���
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; ++i) {
                swap(array, start, i);  //  ����Ԫ��(��1,2,3�ֱ����������λ)
                permute(array, start + 1);  //�������ٽ���ȫ�����㷨
                swap(array, start, i);  //��ԭ��ԭ�������飬������һ�ε�ȫ����(�ٽ�����ȥ)
            }
        }
    }


    private static void swap(int[] array, int s, int i) {
        int t = array[s];
        array[s] = array[i];
        array[i] = t;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1};
        permute(array, 0);
    }
}


