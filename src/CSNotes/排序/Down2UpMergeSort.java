package CSNotes.����;

/**
 * �Ե����Ϲ鲢����
 * �ȹ鲢��Щ΢�����飬Ȼ��ɶԹ鲢�õ���΢�����顣
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    //3 4 5 1 2 6 7 sz=1 lo=0
    //[3 4] [1 5] [2 6] 7 sz=1 lo=2
    //[1 3 4 5] [2 6] 7 sz=1 lo=4
    //[1 3 4 5] [2 6 7] sz=2 lo=0
    //[1 2 3 4 5 6 7] sz=4 lo=0
    public static void main(String[] args) {
        Down2UpMergeSort<Integer> down2UpMergeSort = new Down2UpMergeSort<>();
        down2UpMergeSort.sort(new Integer[]{3, 4, 5, 1, 2, 6, 7});
    }

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[]) new Comparable[N];

        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
}
