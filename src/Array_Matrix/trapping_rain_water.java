package Array_Matrix;

//42
//���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
//������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� ��л Marcos ���״�ͼ��
//ʾ��:
//����: [0,1,0,2,1,0,1,3,2,1,2,1]
//���: 6
public class trapping_rain_water {
    public static void main(String[] args) {
        System.out.println(new trapping_rain_water.Solution().trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    //H[i] = min (Max(Array[j]), Max(Array[k])) - Array[i] where j<i and k<i
    //�κ�һ��bar���ݻ����������߷���ұ���߷���ȡһ����Сֵ��Ȼ���ȥ��ǰbar�ĸ߶�
    static class Solution {
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int[] maxL = new int[height.length];//��i�������ߵ�
            int[] maxR = new int[height.length];//��i���ұ���ߵ�
            for (int i = 1; i < height.length; i++) {
                maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                maxR[i] = Math.max(maxR[i + 1], height[i + 1]);
            }
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                result += Math.max((Math.min(maxL[i], maxR[i]) - height[i]), 0);
            }
            return result;
        }
    }
}
