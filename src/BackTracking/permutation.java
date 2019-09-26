package BackTracking;

import java.util.LinkedList;
import java.util.List;

//46
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//示例:
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class permutation {
    //暴力求解
    //如排列1、2、3，则1入队
    //2入队，插入队首1所有可能插入的位置：(1,2) (2,1)入队，1出队
    //3入队，插入队首(1,2) (2,1)所有可能插入的位置：(3,1,2) (1,3,2) (1,2,3)入队 (1,2)出队
    //(3,2,1) (2,3,1) (2,1,3)入队 (2,1)出队
    //出队的个数是本索引的阶乘
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int j = 0; j < nums.length; j++) {
            if (result.size() == 0) {
                LinkedList l = new LinkedList();
                l.add(nums[j]);
                result.add(l);
            } else {
                int count = 0;
                for (int i = 0; i < result.size(); i++) {
                    LinkedList first = (LinkedList) result.getFirst();
                    for (int k = 0; k < first.size() + 1; k++) {
                        LinkedList temp = new LinkedList();
                        temp.addAll(first);
                        temp.add(k, nums[j]);
                        LinkedList temp2 = new LinkedList();
                        temp2.addAll(temp);
                        result.addLast(temp2);
                        temp.removeFirst();
                    }
                    result.removeFirst();
                    count++;
                    if (j == 1 && count == 1) {
                        break;

                    }

                    if (count == doFactorial(j)) {
                        break;
                    }
                }
            }

        }
        return result;

    }

    public static int doFactorial(int n) {
        if (n < 0) {
            return -1;//传入的数据不合法
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {//递归结束的条件
            return 1;
        } else {
            return n * doFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        List<List<Integer>> result = permute(a);
        System.out.println(result);
    }
}

