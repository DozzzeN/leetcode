package Tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830861&tid=32413754
//作为程序员的小Q，他的数列和其他人的不太一样，他有2^n个数。
//老板问了小Q一共m次，每次给出一个整数qi(1<=i<=m), 要求小Q把这些数每2^qi分为一组，
//然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？
//例如:
//对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
//翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。
//输入描述:
//第一行一个数n(0<=n<=20)
//第二行2^n个数，表示初始的序列(1<=初始序列<=10^9)
//第三行一个数m(1<=m<=10^6)
//第四行m个数表示qi(0<=qi<=n)
//输出描述:
//m行每行一个数表示答案。
//输入例子1:
//2
//2 1 4 3
//4
//1 2 0 2
//输出例子1:
//0
//6
//6
//0
//例子说明1:
//初始序列2 1 4 3
//2^q1=2 ->
//第一次：1 2 3 4 -> 逆序对数为0
//2^q2=4 ->
//第二次：4 3 2 1 -> 逆序对数为6
//2^q3=1 ->
//第三次：4 3 2 1 -> 逆序对数为6
//2^q4=4 ->
//第四次：1 2 3 4 -> 逆序对数为0
public class reverse_pair {
    private static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            n = (int) Math.pow(2, n);
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();
            }

            int m = scanner.nextInt();
            int[] qi = new int[m];
            for (int i = 0; i < m; i++) {
                qi[i] = scanner.nextInt();
            }
            solution(n, input, m, qi);
        }
    }

    public static void solution(int n, int[] inputInt, int m, int[] qi) {
        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            grouping(inputInt, (int) Math.pow(2, qi[i]));
            int[] temp = new int[n];
            System.arraycopy(inputInt, 0, temp, 0, n);
            if (!map.containsKey(temp)) {
                map.put(temp, getPairNumber(temp));
            }
            System.out.println(getPairNumber(temp));
        }
    }

    public static void grouping(int[] input, int n) {
        for (int i = 0; i < input.length; i += n) {
            for (int j = 0; j < n / 2; j++) {
                int temp = input[i + j];
                input[i + j] = input[i + n - j - 1];
                input[i + n - j - 1] = temp;
            }
        }
    }

    public static int getPairNumber(int[] array) {
        result = 0;
        if (array == null || array.length <= 1) return 0;
        mergeSort(array, 0, array.length - 1);
        return result;
    }

    private static void mergeOne(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {//如果前面的元素小于后面的不能构成逆序对
                temp[t++] = array[i++];
            } else {//如果前面的元素大于后面的，那么在前面元素之后的元素(i到mid)都能和后面的元素构成逆序对
                temp[t++] = array[j++];
                result += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        //复制到原数组
        if (t >= 0) System.arraycopy(temp, 0, array, left, t);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            mergeOne(array, left, mid, right);
        }
    }
}
