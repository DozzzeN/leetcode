package Alibaba;

//��һ���˿��ƣ�ÿ���ƽ���1��10֮��
//�����ֳ��Ʒ�����
//����1��
//��2�Ŷ���
//������˳�ӣ���12345
//���������ӣ���112233
//��10��������ʾ1-10ÿ�����м��ţ�������Ҫ���ٴ��ܳ���
public class how_many_times_can_I_finish_playing_cards {
    public static void main(String[] args) {
        //112233 45678 678910
        System.out.println(getMinCounts(new int[]{
                2, 2, 2, 1, 1, 2, 2, 2, 1, 1
        }, 0));
    }

    public static int getMinCounts(int[] cards, int current) {
        int result = cards.length;
        if (current >= cards.length) return 0;
        if (cards[current] == 0) return getMinCounts(cards, current + 1);
        if (current + 2 < cards.length && cards[current] >= 2 && cards[current + 1] >= 2 && cards[current + 2] >= 2) {
            cards[current] -= 2;
            cards[current + 1] -= 2;
            cards[current + 2] -= 2;
            result = Math.min(result, 1 + getMinCounts(cards, current));
            cards[current] += 2;
            cards[current + 1] += 2;
            cards[current + 2] += 2;
        }
        if (current + 4 < cards.length && cards[current] >= 1 && cards[current + 1] >= 1 && cards[current + 2] >= 1 && cards[current + 3] >= 1 && cards[current + 4] >= 1) {
            cards[current]--;
            cards[current + 1]--;
            cards[current + 2]--;
            cards[current + 3]--;
            cards[current + 4]--;
            result = Math.min(result, 1 + getMinCounts(cards, current));
            cards[current]++;
            cards[current + 1]++;
            cards[current + 2]++;
            cards[current + 3]++;
            cards[current + 4]++;
        }
        if (cards[current] >= 2) {
            cards[current] -= 2;
            result = Math.min(result, 1 + getMinCounts(cards, current));
            cards[current] += 2;
        }
        if (cards[current] >= 1) {
            cards[current]--;
            result = Math.min(result, 1 + getMinCounts(cards, current));
            cards[current]++;
        }
        return result;
    }
}
