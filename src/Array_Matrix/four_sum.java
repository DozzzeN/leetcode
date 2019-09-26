package Array_Matrix;

import java.util.*;

//18
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
//使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
public class four_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = new Solution().fourSum(nums, 0);
        System.out.println(result);
    }

    //将nums数组中的元素两两组合计算出结果存放在哈希表中
    //遍历哈希表将哈希key之和等于target的记录取出，组合得到结果
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
                            //保证两个索引数组形成的List是有序的呢？我们只需要让第一个数组的较大索引小于第二个数组的较小索引即可
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
