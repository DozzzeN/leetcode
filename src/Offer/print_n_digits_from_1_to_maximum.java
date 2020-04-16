package Offer;

//题目描述
//输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
//解题思路
//由于n可能会非常大，因此不能直接用int表示数字，而是用char数组进行存储。
//使用回溯法得到所有的数。
public class print_n_digits_from_1_to_maximum {
    public static void main(String[] args) {
        new print_n_digits_from_1_to_maximum().print1ToMaxOfNDigits(2);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
