package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
//但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
//没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
//现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

//输出描述:
//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
public class sequential_continuous_positive_numbers {
    public static void main(String[] args) {
        System.out.println(new sequential_continuous_positive_numbers.Solution().FindContinuousSequence(9));
        System.out.println(new sequential_continuous_positive_numbers.Solution().FindContinuousSequence2(9));
    }

    public static class Solution {
        //找递推公式：通过解方程
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = sum; i > 0; i--) {
                ArrayList<Integer> temp = new ArrayList<>();
                if (i % 2 == 1 && (sum - ((i + 1) / 2)) % (i + 1) == 0) {
                    int a = (sum - ((i + 1) / 2)) / (i + 1) - i / 2;
                    if (a <= 0) continue;
                    for (int j = 0; j < i + 1; j++) {
                        temp.add(a + j);
                    }
                    result.add(new ArrayList<>(temp));
                } else if (i % 2 == 0 && sum % (i + 1) == 0) {
                    int a = sum / (i + 1) - i / 2;
                    if (a <= 0) continue;
                    for (int j = 0; j < i + 1; j++) {
                        temp.add(a + j);
                    }
                    result.add(new ArrayList<>(temp));
                }
            }
            return result;
        }

        /**
         * 思路：
         * 输入sum=20（1，2，3，4，5，6，7，8，9，10，11，12，13，14，15
         * 1，定义两个指针，左指针从1开始，右指针从2开始
         * 循环开始
         * 2，求和（1+2 = 3
         * 3，如果判断3小于20，右指针++，2变为3，求和3+3=6。循环一直到右指针=6，和为21。
         * 4，else if 判断21大于20，左指针++，1变为2，和减去左指针值，和为21-1=20。
         * 5，else 和与输入一样，存数。   【再把右指针++，求和，求剩余组合】
         * 循环结束
         */
        public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int left = 1, right = 2;
            int sumValue = left + right;
            while (sum > right) {
                if (sumValue < sum) {
                    right++;
                    sumValue += right;
                } else if (sumValue > sum) {
                    sumValue -= left;
                    left++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        temp.add(i);
                    }
                    result.add(temp);
                    right++;
                    sumValue += right;
                }
            }
            return result;
        }
    }
}
