package Tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830863&tid=32436460
//СQ�ڽ���һ��������Ϸ,�ⳡ��Ϸ��ʤ���ؼ��������ܷ�������һ������ΪL�ĺӵ�,�����Կ�����[0,L]��һ�����ᡣ
//������Ϸ������n�������ṩ��Ұ�ĵ���-��������,��i�����������ܹ���������[xi,yi]������СQ��֪�������ü������������Ϳ��Ը������κӵ���
//��������:
//�������n+1�С�
//��һ�а�������������n��L(1<=n<=105,1<=L<=109)
//��������n��,ÿ������������xi,yi(0<=xi<=yi<=109),��ʾ��i�������������ǵ����䡣
//�������:
//һ����������ʾ������Ҫ��������������, ����޽�, ���-1��
//��������1:
//4 6
//3 6
//2 4
//0 2
//4 7
//�������1:
//3

/**
 * 10 28
 * 5 24
 * 8 27
 * 9 19
 * 3 17
 * 13 18
 * 9 25
 * 19 29
 * 12 15
 * 25 29
 * 0 6
 */

//Ϊ�λ�Խ��
public class vision_competition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[] map = new int[l];
        Map<Integer, Integer> input = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (input.containsKey(x)) {
                input.put(x, Math.max(y, input.get(x)));
            } else {
                input.put(x, y);
            }
        }
        for (Map.Entry<Integer, Integer> entries : input.entrySet()) {
            if (entries.getKey() < 0) {
                map[0] = entries.getValue();
            } else {
                map[entries.getKey()] = entries.getValue();
            }
        }
        if (map[0] == 0) System.out.println(-1);
        int max = map[0];
        int result = 1;
        int cur = map[0];
        for (int i = 1; i < map.length && cur < l; i++) {
            if (i <= cur) {
                max = Math.max(max, map[i]);
            } else {
                if (i > max) {
                    System.out.println(-1);
                    return;
                } else {
                    cur = max;
                    max = map[i];
                    result++;
                }
            }
        }
        if (cur != max) {
            cur = max;
            result++;
        }
        if (cur < l) System.out.println(-1);
        else System.out.println(result);
    }
}
