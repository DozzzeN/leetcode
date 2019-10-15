package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90
//����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
//˵�����⼯���ܰ����ظ����Ӽ���
//ʾ��:
//����: [1,2,2]
//���:
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
            //j>i��ʾ��i��ʼ�������飬����������j��Ԫ��
            //��i��ȡֵΪ0��1��2����һ�α�������
            if (j > i && nums[j - 1] == nums[j]) {
                continue;
            }
            tmp.add(nums[j]);//����������
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);//������������
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
