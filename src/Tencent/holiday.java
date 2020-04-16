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
//回溯超时
public class holiday {
    static int result = 0;
    static int max = 0;
    static int lastGongzuo = -2;
    static int lastJianshen = -2;

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
        solution(gongzuo, jianshen, 0);
        System.out.println(n - max);
    }

    public static void solution(int[] gongzuo, int[] jianshen, int cur) {
        if (cur == gongzuo.length) {
            max = Math.max(max, result);
            return;
        }
        if (cur - lastGongzuo > 1) {
            int temp = lastGongzuo;
            lastGongzuo = cur;
            result += gongzuo[cur];
            solution(gongzuo, jianshen, cur + 1);
            result -= gongzuo[cur];
            lastGongzuo = temp;
        }
        if (cur - lastJianshen > 1) {
            int temp = lastJianshen;
            lastJianshen = cur;
            result += jianshen[cur];
            solution(gongzuo, jianshen, cur + 1);
            result -= jianshen[cur];
            lastJianshen = temp;
        }
        //休息
        solution(gongzuo, jianshen, cur + 1);
    }
}
