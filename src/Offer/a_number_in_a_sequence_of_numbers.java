package Offer;

//������0123456789101112131415...�ĸ�ʽ���л���һ���ַ����У�������ַ����ĵ�indexλ��
public class a_number_in_a_sequence_of_numbers {
    public static void main(String[] args) {
        System.out.println(new a_number_in_a_sequence_of_numbers().getDigitAtIndex(12));
    }

    public int getDigitAtIndex(int index) {
        if (index < 0) return -1;
        int place = 1;  //1��ʾ��λ��2��ʾʮλ...
        while (true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount * place;
            if (index < totalAmount) return getDigitAtIndex(index, place);
            index -= totalAmount;
            place++;
        }
    }

    /**
     * placeλ�������ֵĸ���
     * 10,90,900,...
     */
    private int getAmountOfPlace(int place) {
        if (place == 1) return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }

    /**
     * placeλ������ʼ����
     * 0,10,100,...
     */
    private int getBeginNumberOfPlace(int place) {
        if (place == 1) return 0;
        return (int) Math.pow(10, place - 1);
    }

    /**
     * ��placeλ����ɵ��ַ����У���index����
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }
}
