public class test {
    public static void main(String[] args) {
        //==比较的是地址
        //但是当为基本类型时,比较的是值,如果俩边有包装类型,则先将包装类型转换为基本类型在比较值是否相等。
        //当俩边都为包装类型时,即为对象,比较的是地址。
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);//也就是Integer i03 = 59;
        Integer i04 = new Integer(59);
        Integer i05 = new Integer(59);
        System.out.println(i01 == i02);//Integer转为int值比较
        System.out.println(i01 == i03);//-128到127会缓存到Integer的常量池，Integer.valueOf会被编译器优化成i01的形式
        System.out.println(i01 == i04);//i04产生新的对象，比较地址
        System.out.println(i02 == i03);//-128到127会缓存到Integer的常量池
        System.out.println(i02 == i04);//比较值
        System.out.println(i03 == i04);//i04产生新的对象，比较地址
        System.out.println(i04 == i05);//两个对象的地址不同

        System.out.println();

        Integer i06 = 128;
        int i07 = 128;
        Integer i08 = Integer.valueOf(128);
        Integer i09 = new Integer(128);
        Integer i10 = new Integer(128);
        System.out.println(i06 == i07);//Integer转为int值比较
        System.out.println(i06 == i08);//-128到127会缓存到Integer的常量池，Integer.valueOf会被编译器优化成i01的形式
        System.out.println(i06 == i09);//i04产生新的对象，比较地址
        System.out.println(i07 == i08);//-128到127会缓存到Integer的常量池
        System.out.println(i07 == i09);//比较值
        System.out.println(i08 == i09);//i04产生新的对象，比较地址
        System.out.println(i09 == i10);//两个对象的地址不同

        String s1 = "xiaopeng";
        String s2 = "xiaopeng";
        String s3 = s1;
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
