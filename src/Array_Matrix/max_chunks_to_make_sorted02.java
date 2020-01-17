package Array_Matrix;

//769
public class max_chunks_to_make_sorted02 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
//        int[] arr = {0,2,1};
        System.out.println(new max_chunks_to_make_sorted02.Solution().maxChunksToSorted(arr));
    }

    //当遍历到第i个位置时，如果可以切分为块，那前i个位置的最大值一定等于i。
    //否则，一定有比i小的数划分到后面的块，那块排序后，一定不满足升序。
    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            if (arr == null) {
                return 0;
            }
            int result = 0;
            int right = arr[0];
            for (int i = 0; i < arr.length; i++) {
                right = Math.max(right, arr[i]);//类似于排序
                if (right == i) {//排序好最大的元素若和数组一致，则可以分块
                    result++;
                }
            }
            return result;
        }
    }
}
