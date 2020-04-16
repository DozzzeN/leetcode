package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
public class the_minimum_number_of_K {
    public static void main(String[] args) {
        System.out.println(new the_minimum_number_of_K.Solution().GetLeastNumbers_Solution(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10
        ));
    }

    //���������partition()�������᷵��һ������jʹ��a[l..j-1]С�ڵ���a[j]����a[j+1..h]���ڵ���a[j]��
    //��ʱa[j]��������ĵ�j��Ԫ�ء�����������������ҳ�����ĵ�K��Ԫ�أ������ҵ�K��Ԫ�ص��㷨��Ϊ����ѡ���㷨��
    public static class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            ArrayList<Integer> result = new ArrayList<>();
            if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;
            findKthSmallest(input, k - 1);
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }

        public void findKthSmallest(int[] nums, int k) {
            int l = 0, h = nums.length - 1;
            while (l < h) {
                int j = partition(nums, l, h);
                if (j == k) break;//j���ǵ�k��Ԫ��
                //��j��ʼ����
                if (j > k) h = j - 1;
                else l = j + 1;
            }
        }

        //�����е�partition�㷨
        private int partition(int[] nums, int l, int h) {
            int p = nums[l];
            int i = l, j = h + 1;
            while (true) {
                while (i != h && nums[++i] < p) ;
                while (j != l && nums[--j] > p) ;
                if (i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, l, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
