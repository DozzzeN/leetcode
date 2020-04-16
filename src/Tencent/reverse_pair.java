package Tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830861&tid=32413754
//��Ϊ����Ա��СQ���������к������˵Ĳ�̫һ��������2^n������
//�ϰ�����СQһ��m�Σ�ÿ�θ���һ������qi(1<=i<=m), Ҫ��СQ����Щ��ÿ2^qi��Ϊһ�飬
//Ȼ���ÿ����з�ת��СQ��֪��ÿ�β��������������е�����Ը����Ƕ����أ�
//����:
//��������1 3 4 2���������(4, 2),(3, 2),������Ϊ2��
//��ת֮��Ϊ2 4 3 1���������(2, 1),(4, 3), (4, 1), (3, 1),������Ϊ4��
//��������:
//��һ��һ����n(0<=n<=20)
//�ڶ���2^n��������ʾ��ʼ������(1<=��ʼ����<=10^9)
//������һ����m(1<=m<=10^6)
//������m������ʾqi(0<=qi<=n)
//�������:
//m��ÿ��һ������ʾ�𰸡�
//��������1:
//2
//2 1 4 3
//4
//1 2 0 2
//�������1:
//0
//6
//6
//0
//����˵��1:
//��ʼ����2 1 4 3
//2^q1=2 ->
//��һ�Σ�1 2 3 4 -> �������Ϊ0
//2^q2=4 ->
//�ڶ��Σ�4 3 2 1 -> �������Ϊ6
//2^q3=1 ->
//�����Σ�4 3 2 1 -> �������Ϊ6
//2^q4=4 ->
//���ĴΣ�1 2 3 4 -> �������Ϊ0
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
            if (array[i] <= array[j]) {//���ǰ���Ԫ��С�ں���Ĳ��ܹ��������
                temp[t++] = array[i++];
            } else {//���ǰ���Ԫ�ش��ں���ģ���ô��ǰ��Ԫ��֮���Ԫ��(i��mid)���ܺͺ����Ԫ�ع��������
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
        //���Ƶ�ԭ����
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
