public class test {
    public static void main(String[] args) {
        //==�Ƚϵ��ǵ�ַ
        //���ǵ�Ϊ��������ʱ,�Ƚϵ���ֵ,��������а�װ����,���Ƚ���װ����ת��Ϊ���������ڱȽ�ֵ�Ƿ���ȡ�
        //�����߶�Ϊ��װ����ʱ,��Ϊ����,�Ƚϵ��ǵ�ַ��
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);//Ҳ����Integer i03 = 59;
        Integer i04 = new Integer(59);
        Integer i05 = new Integer(59);
        System.out.println(i01 == i02);//IntegerתΪintֵ�Ƚ�
        System.out.println(i01 == i03);//-128��127�Ỻ�浽Integer�ĳ����أ�Integer.valueOf�ᱻ�������Ż���i01����ʽ
        System.out.println(i01 == i04);//i04�����µĶ��󣬱Ƚϵ�ַ
        System.out.println(i02 == i03);//-128��127�Ỻ�浽Integer�ĳ�����
        System.out.println(i02 == i04);//�Ƚ�ֵ
        System.out.println(i03 == i04);//i04�����µĶ��󣬱Ƚϵ�ַ
        System.out.println(i04 == i05);//��������ĵ�ַ��ͬ

        System.out.println();

        Integer i06 = 128;
        int i07 = 128;
        Integer i08 = Integer.valueOf(128);
        Integer i09 = new Integer(128);
        Integer i10 = new Integer(128);
        System.out.println(i06 == i07);//IntegerתΪintֵ�Ƚ�
        System.out.println(i06 == i08);//-128��127�Ỻ�浽Integer�ĳ����أ�Integer.valueOf�ᱻ�������Ż���i01����ʽ
        System.out.println(i06 == i09);//i04�����µĶ��󣬱Ƚϵ�ַ
        System.out.println(i07 == i08);//-128��127�Ỻ�浽Integer�ĳ�����
        System.out.println(i07 == i09);//�Ƚ�ֵ
        System.out.println(i08 == i09);//i04�����µĶ��󣬱Ƚϵ�ַ
        System.out.println(i09 == i10);//��������ĵ�ַ��ͬ

        String s1 = "xiaopeng";
        String s2 = "xiaopeng";
        String s3 = s1;
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
