package Offer;

//https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class rotate_the_smallest_number_of_an_array {
    public static void main(String[] args) {
        System.out.println(new rotate_the_smallest_number_of_an_array.Solution().minNumberInRotateArray(
                new int[]{1, 0, 1, 1, 1}
        ));
        System.out.println(new rotate_the_smallest_number_of_an_array.Solution().minNumberInRotateArray2(
                new int[]{1, 0, 1, 1, 1}
        ));
    }

    public static class Solution {
        public int minNumberInRotateArray(int[] array) {
            if (array == null || array.length == 0) return 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    return array[i];
                }
            }
            return array[0];
        }

        //二分法
        //将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。
        //新的旋转数组的数组元素是原数组的一半，
        //从而将问题规模减少了一半，这种折半性质的算法的时间复杂度为O(logN)。
        public int minNumberInRotateArray2(int[] array) {
            if (array == null || array.length == 0) return 0;
            int left = 0, right = array.length - 1, mid;
            while (left < right) {
                //特殊情况，非递减数组
                if (array[left] < array[right])
                    return array[left];
                mid = (left + right) >>> 1;
                if (array[mid] > array[left]) {
                    left = mid + 1;
                } else if (array[right] > array[mid]) {
                    right = mid;
                } else {
                    left++;
                }
            }
            return array[left];
        }
    }
}
