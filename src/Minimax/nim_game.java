package Minimax;

//292
//���������ѣ�������һ���� Nim ��Ϸ����������һ��ʯͷ��ÿ�����������õ� 1 - 3 ��ʯͷ�� �õ����һ��ʯͷ���˾��ǻ�ʤ�ߡ�����Ϊ���֡�
//�����Ǵ����ˣ�ÿһ���������Ž⡣ ��дһ�����������ж����Ƿ�����ڸ���ʯͷ�����������Ӯ����Ϸ��
//ʾ��:
//����: 4
//���: false
//����: ��������� 4 ��ʯͷ����ô����Զ����Ӯ�ñ�����
//     ��Ϊ���������� 1 �顢2 �� ���� 3 ��ʯͷ�����һ��ʯͷ���ǻᱻ����������ߡ�
public class nim_game {
    public static void main(String[] args) {
        System.out.println(new nim_game.Solution().canWinNim(11));
    }

    static class Solution {
        public boolean canWinNim(int n) {
//            return n % 4 != 0;
            return (n & 3) != 0;
        }
    }
}
