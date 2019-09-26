package Array_Matrix;

import java.util.Arrays;
//769
//数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
//之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
//输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
public class max_chunks_to_make_sorted {
    public static void main(String[] args) {
//        int[] arr = {1,0,2,3,4};
        int[] arr = {0,2,1};
        System.out.println(new max_chunks_to_make_sorted.Solution().maxChunksToSorted(arr));
    }

    static class Solution {
        //原数组与已排序数组作比较
        public int maxChunksToSorted(int[] arr) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr);//准备已排序的数组
            int result = 0;
            boolean flag = false;//是否可以分块
            for (int i = 0; i < arr.length; i++) {
                int[] temp = Arrays.copyOf(copy, copy.length);
                Arrays.sort(temp, 0, i + 1);//只从0到i排序
                for (int j = 0; j <= i; j++) {//遍历这i个数字是否和已排序数组一致，若一致则可以进行分块
                    if (arr[j] != temp[j]) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if (flag) {
                    result++;
                }
            }
            return result;
        }
    }
}
