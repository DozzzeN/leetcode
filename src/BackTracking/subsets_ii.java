package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//说明：解集不能包含重复的子集。
//示例:
//输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class subsets_ii {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> temp = new ArrayList<>();


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        result.clear();
        result.addAll(simpleSets(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            temp.clear();
            temp.addAll(result);
            for (List<Integer> list : temp) {
                if (result.contains(concat(list, nums[i]))) {
                    continue;
                }
                result.add(concat(list, nums[i]));
            }
        }
        return result;
    }

    static List<Integer> concat(List<Integer> list, int b) {
        List<Integer> c = new ArrayList<>(list);
        c.add(b);
        return c;
    }

    //输入a返回{a} {}
    public static List<List<Integer>> simpleSets(int element) {
        List<Integer> ele = new ArrayList<>();
        ele.add(element);
        List<Integer> empty = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(ele);
        res.add(empty);
        return res;
    }

    //别人的解法
    //每次遍历数组的新元素都选择加入或不加入
    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            //j>i表示从i开始遍历数组，当遍历到第j个元素
            //如i的取值为0，1，2，第一次遍历不会
            if (j > i && nums[j - 1] == nums[j]) {
                continue;
            }
            tmp.add(nums[j]);//加入这个结点
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);//不加入这个结点
        }
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        Arrays.sort(nums);
        System.out.println(subsetsWithDup2(nums));
    }
}
