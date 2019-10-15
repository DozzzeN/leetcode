package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//78
//����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
//˵�����⼯���ܰ����ظ����Ӽ���
//ʾ��:
//����: nums = [1,2,3]
//���:
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

    //ÿ����һ��Ԫ����ɵ��µ��ݼ� = ����ǰ���ݼ� + ��Ԫ��������ǰ�ݼ������
    //step1: X1 = {a}
    //�ݼ�: {}��{a}
    //step2: X2 = {a,b}
    //�ݼ�: {}��{a} + ({}{b} + {a}{b}) = {} ��{a}��{b}��{a,b}
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

    //����a����{a} {}
    public static List<List<Integer>> simpleSets(int element) {
        List<Integer> ele = new ArrayList<>();
        ele.add(element);
        List<Integer> empty = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(ele);
        res.add(empty);
        return res;
    }

    //���˵Ľⷨ
    //ÿ�α����������Ԫ�ض�ѡ�����򲻼���
    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);//����������
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);//������������
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
