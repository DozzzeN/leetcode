package CSNotes.排序;

/**
 * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 当输入的元素是n个0到k之间的整数时，它的运行时间是Θ(n+k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。
 * 由于用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），这使得计数排序对于数据范围很大的数组，需要大量时间和内存。例如：计数排序是用来排序0到100之间的数字的最好的算法，但是它不适合按字母顺序排序人名。但是，计数排序可以用在基数排序中的算法来排序数据范围很大的数组。
 * 通俗地理解，例如有10个年龄不同的人，统计出有8个人的年龄比A小，那A的年龄就排在第9位,用这个方法可以得到其他每个人的位置,也就排好了序。当然，年龄有重复时需要特殊处理（保证稳定性），这就是为什么最后要反向填充目标数组，以及将每个数字的统计减去1的原因。
 */
public class CountingSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        CountingSort<Integer> countingSort = new CountingSort<>();
        countingSort.sort(new Integer[]{2, 3, 4, 5, 1, 2, 4, 6});
    }

    @Override
    public void sort(T[] nums) {
        T maxValue = getMaxValue(nums);
        int bucketLen = Integer.parseInt(maxValue.toString()) + 1;
        int[] bucket = new int[bucketLen];

        for (T value : nums) {
            bucket[Integer.parseInt(value.toString())]++;
        }

        for (int j = 0, sortedIndex = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                nums[sortedIndex++] = (T) Integer.valueOf(j);
                bucket[j]--;
            }
        }
    }

    private T getMaxValue(T[] nums) {
        T maxValue = nums[0];
        for (T value : nums) {
            if (less(maxValue, value)) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
