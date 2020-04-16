package CSNotes.排序;

/**
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 * 希尔排序使用插入排序对间隔h的序列进行排序。通过不断减小h，最后令h=1，就可以使得整个数组是有序的。
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    //3 4 5 1 2 6 7  h=4
    //2 4 5 1 3 6 7
    //2 4 5 1 3 6 7  h=1
    //2 4 5 1 3 6 7
    //2 4 5 1 3 6 7
    //2 4 1 5 3 6 7
    //2 1 4 5 3 6 7
    //1 2 4 5 3 6 7
    //1 2 4 3 5 6 7
    //1 2 3 4 5 6 7

    public static void main(String[] args) {
        Shell<Integer> shell = new Shell<>();
        shell.sort(new Integer[]{3, 4, 5, 1, 2, 6, 7});
    }

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //类似插入排序
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}