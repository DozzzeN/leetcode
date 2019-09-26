package Array_Matrix;

import java.util.*;
//697
//����һ���ǿ���ֻ�����Ǹ������������� nums, ����ĶȵĶ�����ָ��������һԪ�س���Ƶ�������ֵ��
//����������ҵ��� nums ӵ����ͬ��С�Ķȵ�������������飬�����䳤�ȡ�
public class degree_of_an_array {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        System.out.println(new Solution().findShortestSubArray(nums));
    }

    static class Solution {
        public int findShortestSubArray(int[] nums) {
            //ԭ����Ŀ���
            List<Integer> tempArray = new ArrayList<>(nums.length);
            for (int i : nums) {
                tempArray.add(i);
            }
            //���ԭ����Ԫ�أ������͸�Ԫ�س��ִ�����ֵ��
            Map<Integer, Integer> NumberElements = new HashMap<>();
            for (int i = 0; i < tempArray.size(); i++) {
                if (((NumberElements.get(tempArray.get(i)) != null)) &&
                        (NumberElements.containsKey(tempArray.get(i)))) {
                    //�ظ��������һ
                    int tmp = NumberElements.get(tempArray.get(i));
                    NumberElements.remove(tempArray.get(i));
                    NumberElements.put(tempArray.get(i), tmp + 1);
                } else {
                    //��һ�γ��ִ���Ϊһ
                    NumberElements.put(tempArray.get(i), 1);
                }
            }
            int MaxCounts = 0;
            for (int i : NumberElements.values()) {
                //�ҵ�������
                MaxCounts = Math.max(i, MaxCounts);
            }
            int MaxNum;
            int MinDegree = tempArray.size();
            for (int i : NumberElements.keySet()) {
                if (NumberElements.get(i) == MaxCounts) {
                    //������������Ԫ��
                    MaxNum = i;
                    //Ԫ�ع��������е���̳��ȣ���������Ԫ�ز�Ψһ
                    MinDegree = Math.min(MinDegree, tempArray.lastIndexOf(MaxNum) - tempArray.indexOf(MaxNum) + 1);
                }

            }
            return MinDegree;
        }
    }
}
