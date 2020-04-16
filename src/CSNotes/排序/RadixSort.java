package CSNotes.����;

import java.util.Arrays;

/**
 * ����������һ�ַǱȽ������������㷨����ԭ���ǽ�������λ���и�ɲ�ͬ�����֣�Ȼ��ÿ��λ���ֱ�Ƚϡ�
 * ��������Ҳ���Ա���ַ������������ֻ����ڣ����ض���ʽ�ĸ����������Ի�������Ҳ����ֻ��ʹ����������
 * �������� vs �������� vs Ͱ����
 * �����������㷨��������Ͱ�ĸ������Ͱ��ʹ�÷����������Բ��죺
 * �������򣺸��ݼ�ֵ��ÿλ����������Ͱ��
 * ��������ÿ��Ͱֻ�洢��һ��ֵ��
 * Ͱ����ÿ��Ͱ�洢һ����Χ����ֵ��
 */
public class RadixSort<T extends Comparable<T>> extends Sort<T> {
    //50 2 36 46 26 4 3 27 44 38 15 19
    //[50] [2] [3] [4 44] [15] [36 46 26] [27] [38] [19] ����λ
    //[2 3 4] [15 19] [26 27] [36 38] [44 46] [50] ��ʮλ
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
     * ��ȡ���λ��
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
            //���Ǹ����������������չһ��������������[0-9]��Ӧ������[10-19]��Ӧ����(bucket+10)
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