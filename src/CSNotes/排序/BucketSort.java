package CSNotes.排序;

import java.util.Arrays;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。为了使桶排序更加高效，我们需要做到这两点：
 * 在额外空间充足的情况下，尽量增大桶的数量
 * 使用的映射函数能够将输入的N个数据均匀的分配到K个桶中
 * 同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。
 * 1. 什么时候最快
 * 当输入的数据可以均匀的分配到每一个桶中。
 * 2. 什么时候最慢
 * 当输入的数据被分配到了同一个桶中。
 */
public class BucketSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        BucketSort<Integer> bucketSort = new BucketSort<>();
        bucketSort.sort(new Integer[]{2, 3, 4, 5, 7, 123, 5, 32, 345, 2, 4});
    }

    @Override
    public void sort(T[] nums) {
        bucketSort(nums, 5);
    }

    private void bucketSort(T[] nums, int bucketSize) {
        T minValue = nums[0];
        T maxValue = nums[0];
        for (T value : nums) {
            if (less(value, minValue)) {
                minValue = value;
            } else if (more(value, maxValue)) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((Integer.parseInt(maxValue.toString()) - Integer.parseInt(minValue.toString())) / bucketSize) + 1;
        T[][] buckets = (T[][]) new Comparable[bucketCount][0];

        //利用映射函数将数据分配到各个桶中
        for (T num : nums) {
            int index = (int) Math.floor((Integer.parseInt(num.toString()) - Integer.parseInt(minValue.toString())) / bucketSize);
            buckets[index] = arrAppend(buckets[index], num);
        }

        int arrIndex = 0;
        for (T[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            //对每个桶进行排序，这里使用了插入排序
            Insertion<T> insertion = new Insertion<>();
            insertion.sort(bucket);
            for (T value : bucket) {
                nums[arrIndex++] = value;
            }
        }
        System.out.println(1);
    }

    private T[] arrAppend(T[] nums, T value) {
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = value;
        return nums;
    }
}
