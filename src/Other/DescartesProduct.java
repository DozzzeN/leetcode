package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * n个集合的笛卡尔积
 */
public class DescartesProduct {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(7);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        List<Integer> l4 = new ArrayList<>();
        l4.add(8);
        l4.add(9);
        input.add(l1);
        input.add(l2);
        input.add(l3);
        input.add(l4);
        System.out.println(Solution.DescartesProduct(input));
    }

    public static class Solution {
        static List<List<Integer>> DescartesProduct(List<List<Integer>> input) {
            List<List<Integer>> result = new ArrayList<>();
            if (input.size() >= 2) {
                List<Integer> temp = new ArrayList<>();
                int length1 = input.get(0).size();
                int length2 = input.get(1).size();
                for (int i = 0; i < length1; i++) {
                    for (int j = 0; j < length2; j++) {
                        temp.add(input.get(0).get(i));
                        temp.add(input.get(1).get(j));
                        result.add(temp);
                        temp = new ArrayList<>();
                    }
                }
                for (int i = 2; i < input.size(); i++) {
                    length1 = input.get(i).size();
                    length2 = result.size();
                    for (int j = 0; j < length1; j++) {
                        for (int k = 0; k < length2; k++) {
                            temp = new ArrayList<>(result.get(k));
                            temp.add(input.get(i).get(j));
                            result.add(temp);
                        }
                    }
                    for (int j = 0; j < length2; j++) {
                        result.remove(0);
                    }
                }
            }
            return result;
        }
    }
}
