package CSNotes.排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 * <p>
 * 快速排序是原地排序，不需要辅助数组，但是递归调用需要辅助栈。
 * 快速排序最好的情况下是每次都正好将数组对半分，这样递归调用次数才是最少的。这种情况下比较次数为CN=2CN/2+N，复杂度为 O(NlogN)。
 * 最坏的情况下，第一次从最小的元素切分，第二次从第二小的元素切分，如此这般。因此最坏的情况下需要比较N^2/2。
 * 为了防止数组最开始就是有序的，在进行快速排序时需要随机打乱数组。
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    //3 4 5 1 2 6 7
    //5 6 7 4 3 1 2 shuffle
    //5 2 7 4 3 1 6
    //5 2 1 4 3 7 6 i=5 j=4
    //3 2 1 4 5 7 6
    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(new Integer[]{3, 4, 5, 1, 2, 6, 7});
    }

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    protected void sort(T[] nums, int l, int h) {
        if (h <= l) return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * 取a[l]作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，
     * 再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。不断进行这个过程，
     * 就可以保证左指针i的左侧元素都不大于切分元素，右指针j的右侧元素都不小于切分元素。
     * 当两个指针相遇时，将切分元素a[l]和a[j]交换位置。
     */
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        //从l+1到h进行与nums[l]的比较
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }


    /**
     * 快速排序的partition()方法，会返回一个整数j使得a[l..j-1]小于等于a[j]，且a[j+1..h]大于等于a[j]，此时a[j]就是数组的第j大元素。
     * 可以利用这个特性找出数组的第k个元素。
     * 该算法是线性级别的，假设每次能将数组二分，那么比较的总次数为 (N+N/2+N/4+..)，直到找到第k个元素，这个和显然小于2N。
     */
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == k) {
                return nums[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }
}