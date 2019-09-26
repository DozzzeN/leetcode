package BackTracking;

import java.util.Arrays;

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
public class permutation02 {
    //s表示，从array[start]后的数据进行全排列
    public static void permute(int[] array, int start) {
        if (start == array.length) {  // 输出
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; ++i) {
                swap(array, start, i);  //  交换元素(将1,2,3分别放在数组首位)
                permute(array, start + 1);  //交换后，再进行全排列算法
                swap(array, start, i);  //还原成原来的数组，便于下一次的全排列(再交换回去)
            }
        }
    }


    private static void swap(int[] array, int s, int i) {
        int t = array[s];
        array[s] = array[i];
        array[i] = t;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1};
        permute(array, 0);
    }
}


