package Array_Matrix;

import java.util.*;

//18
//����һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��
//ʹ�� a + b + c + d ��ֵ�� target ��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣
public class four_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = new Solution().fourSum(nums, 0);
        System.out.println(result);
    }

    //��nums�����е�Ԫ��������ϼ�����������ڹ�ϣ����
    //������ϣ����ϣkey֮�͵���target�ļ�¼ȡ������ϵõ����
    static public class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Set<List<Integer>> listSet = new HashSet<>();
            int n = nums.length;
            Arrays.sort(nums);
            HashMap<Integer, List<Integer[]>> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int num = nums[i] + nums[j];
                    Integer[] pair = {i, j};
                    if (hashMap.containsKey(num)) {
                        hashMap.get(num).add(pair);
                    } else {
                        List<Integer[]> list = new ArrayList<>();
                        list.add(pair);
                        hashMap.put(num, list);
                    }
                }
            }
            for (Integer integer : hashMap.keySet()) {
                if (hashMap.containsKey(target - integer)) {
                    List<Integer[]> list1 = hashMap.get(integer);
                    List<Integer[]> list2 = hashMap.get(target - integer);
                    for (Integer[] pair1 : list1) {
                        int index1 = pair1[0];
                        int index2 = pair1[1];
                        for (Integer[] pair2 : list2) {
                            int index3 = pair2[0];
                            int index4 = pair2[1];
                            //��֤�������������γɵ�List��������أ�����ֻ��Ҫ�õ�һ������Ľϴ�����С�ڵڶ�������Ľ�С��������
                            if (index2 < index3) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[index1]);
                                list.add(nums[index2]);
                                list.add(nums[index3]);
                                list.add(nums[index4]);
                                listSet.add(list);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(listSet);
        }
    }
}
