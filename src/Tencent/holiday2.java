package Tencent;

import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830862&tid=32436460
//由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
//他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。
//给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
//
//输入描述:
//第一行一个整数n(1<=n<=100000) 表示放假天数
//第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
//第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
//（1为营业 0为不营业）
//输出描述:
//一个整数，表示小Q休息的最少天数
//输入例子1:
//4
//1 1 0 0
//0 1 1 0
//输出例子1:
//2
//例子说明1:
//小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天

/**
 * 4
 * 1 1 0 1
 * 1 0 1 1
 */
//动态规划
public class holiday2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] gongzuo = new int[n];
        int[] jianshen = new int[n];
        for (int i = 0; i < n; i++) {
            gongzuo[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            jianshen[i] = scanner.nextInt();
        }
        int[] f1 = new int[n + 1];//最后一天休息，最大的工作/健身天数
        int[] f2 = new int[n + 1];//最后一天工作，最大的工作/健身天数
        int[] f3 = new int[n + 1];//最后一天健身，最大的工作/健身天数
        for (int i = 1; i <= n; i++) {
            f1[i] = Math.max(f1[i - 1], Math.max(f2[i - 1], f3[i - 1]));
            if (gongzuo[i - 1] == 1) {
                f2[i] = Math.max(f1[i - 1], f3[i - 1]) + 1;
            }
            if (jianshen[i - 1] == 1) {
                f3[i] = Math.max(f1[i - 1], f2[i - 1]) + 1;
            }
        }
        System.out.println(n - Math.max(f1[n], Math.max(f2[n], f3[n])));
    }
}
