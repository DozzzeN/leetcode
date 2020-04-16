package CSNotes.排序;

import java.util.Arrays;

/**
 * 基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
 * 基数排序 vs 计数排序 vs 桶排序
 * 这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
 * 基数排序：根据键值的每位数字来分配桶；
 * 计数排序：每个桶只存储单一键值；
 * 桶排序：每个桶存储一定范围的数值；
 */
public class RadixSort<T extends Comparable<T>> extends Sort<T> {
    //50 2 36 46 26 4 3 27 44 38 15 19
    //[50] [2] [3] [4 44] [15] [36 46 26] [27] [38] [19] 按个位
    //[2 3 4] [15 19] [26 27] [36 38] [44 46] [50] 按十位
    //2 3 4 15 19 26 27 36 38 44 46 50
    public static void main(String[] args) {
        RadixSort<Integer> radixSort = new RadixSort<>();
        radixSort.sort(new Integer[]{50, 2, 36, 46, 26, 4, 3, 27, 44, 38, 15, 19});
    }

    @Override
    public void sort(T[] nums) {
        int maxDigit = getMaxDigit(nums);
        radixSort(nums, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(T[] nums) {
        T maxValue = getMaxValue(nums);
        return getNumLength(maxValue);
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

    protected int getNumLength(T num) {
        int temp = Integer.parseInt(num.toString());
        if (temp == 0) {
            return 1;
        }
        int lenght = 0;
        for (; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private void radixSort(T[] nums, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            //考虑负数的情况，这里扩展一倍队列数，其中[0-9]对应负数，[10-19]对应正数(bucket+10)
            T[][] counter = (T[][]) new Comparable[mod * 2][0];

            for (T num : nums) {
                int bucket = ((Integer.parseInt(num.toString()) % mod) / dev) + mod;
                counter[bucket] = arrAppend(counter[bucket], num);
            }

            int pos = 0;
            for (T[] bucket : counter) {
                for (T value : bucket) {
                    nums[pos++] = value;
                }
            }
        }
    }

    private T[] arrAppend(T[] nums, T value) {
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = value;
        return nums;
    }
}