package Other;

import java.math.BigInteger;
import java.security.MessageDigest;

public class test {
    public static final String KEY_SHA = "SHA";

    public static void main(String[] args) {
        addPwd();
        vrfy(1, "[1]", new String[]{
                "[2]", "[6]"
        });

    }

    public static void vrfy(int index, String _value, String[] proof) {
        int residue = index - 1;
        String value = _value;
        for (String s : proof) {
            if (residue % 2 == 0) {
                value = hash(value, s);
                System.out.println(value);
            } else {
                value = hash(s, value);
                System.out.println(value);
            }
            residue /= 2;
        }
    }

    public static String hash(String input1, String input2) {
        return "[" + input1 + "||" + input2 + "]";
    }

    public static void addPwd() {
        String inputStr = "1";
        BigInteger sha;
        System.out.println("=======加密前的数据:" + inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            System.out.println("SHA加密后:" + sha.toString(32));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
