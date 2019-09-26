package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//ÿ����һ��Ԫ����ɵ��µ��ݼ� = ����ǰ���ݼ� + ��Ԫ��������ǰ�ݼ������
//    step1: X1 = {a}
//        �ݼ�: {}��{a}
//    step2: X2 = {a,b}
//        �ݼ�: {}��{a} + ({}{b} + {a}{b}) = {} ��{a}��{b}��{a,b}
public class subsets {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> temp = new ArrayList<>();


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

    static List<Integer> concat(List<Integer> list, int b) {
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            c.add(list.get(i));
        }
        c.add(b);
        return c;
    }

    //����a����{a} {}
    public static List<List<Integer>> simpleSets(int element) {
        List<Integer> ele = new ArrayList<>();
        ele.add(element);
        List<Integer> empty = new ArrayList<>();
        empty.clear();
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
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

//        List<List<Integer>> result = subsets2(nums);
//        for (List<Integer> list : result) {
//            System.out.println(list);
//        }


    }
}
