package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//78
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//说明：解集不能包含重复的子集。
//示例:
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class subsets {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> temp = new ArrayList<>();

    //每增长一个元素组成的新的幂集 = 增长前的幂集 + 该元素与增长前幂集的组合
    //step1: X1 = {a}
    //幂集: {}、{a}
    //step2: X2 = {a,b}
    //幂集: {}、{a} + ({}{b} + {a}{b}) = {} 、{a}、{b}、{a,b}
    public static List<List<Integer>> subsets(int[] nums) {
        result.clear();
        result.addAll(simpleSets(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            temp.clear();
            temp.addAll(result);
            for (List<Integer> list : temp) {
                result.add(concat(list, nums[i]));
            }
        }
        return result;
    }

    public static List<Integer> concat(List<Integer> list, int b) {
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
            tmp.add(nums[j]);//加入这个结点
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);//不加入这个结点
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Arrays.sort(nums);
        System.out.println(subsets(nums));
    }
}
