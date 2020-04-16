package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
public class arrange_the_array_to_the_smallest_number {
    public static void main(String[] args) {
        System.out.println(new arrange_the_array_to_the_smallest_number.Solution().PrintMinNumber(
                new int[]{3334, 3, 3333332}
        ));
        System.out.println(new arrange_the_array_to_the_smallest_number.Solution().PrintMinNumber02(
                new int[]{3334, 3, 3333332}
        ));
        System.out.println(new arrange_the_array_to_the_smallest_number.Solution().PrintMinNumber03(
                new int[]{3334, 3, 3333332}
        ));
    }

    public static class Solution {
        public String PrintMinNumber(int[] numbers) {
            StringBuilder result = new StringBuilder();
            if (numbers == null || numbers.length == 0) return result.toString();
            List<String> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(number + "");
            }
            list.sort((o1, o2) -> {
                int i = 0, j = 0;
                for (int k = 0; k < Math.max(o1.length(), o2.length()); k++) {
                    int c1 = (i == o1.length() ? o1.charAt(i - 1) : o1.charAt(i));
                    int c2 = (j == o2.length() ? o2.charAt(j - 1) : o2.charAt(j));
                    if (c1 == c2) {
                        if (i < o1.length()) {
                            i++;
                        }
                        if (j < o2.length()) {
                            j++;
                        }
                    } else if (c1 > c2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            });
            for (String s : list) {
                result.append(s);
            }
            return result.toString();
        }

        //贪心算法：o1+o2比o2+o1大时o1就应该在o2前面
        public String PrintMinNumber02(int[] numbers) {
            StringBuilder result = new StringBuilder();
            if (numbers == null || numbers.length == 0) return result.toString();
            List<String> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(number + "");
            }
            list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            for (String s : list) {
                result.append(s);
            }
            return result.toString();
        }

        //可以看成是一个排序问题，在比较两个字符串S1和S2的大小时，应该比较的是S1+S2和S2+S1的大小，
        //如果S1+S2<S2+S1，那么应该把S1排在前面，否则应该把S2排在前面。
        public String PrintMinNumber03(int[] numbers) {
            if (numbers == null || numbers.length == 0) return "";
            String[] nums = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                nums[i] = numbers[i] + "";
            Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
            StringBuilder ret = new StringBuilder();
            for (String str : nums)
                ret.append(str);
            return ret.toString();
        }
    }
}
