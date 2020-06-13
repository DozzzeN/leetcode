import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//SIP is an important protcoal of IP Phone, it could be configed with some special information to display. huntPilot URI is one kind of, and  IP phone will catch and display alert name for third party calling if there is huntPilotName configed in  huntPilot URI.
//
//HuntPilot URI Samples:
//huntpiloturi = "<sip:10000@172.16.130.42>;"                                                 alertName=
//huntpiloturi = " "<sip:10000@172.16.130.42>;                                                alertName=
//huntpiloturi = "huntpilotname<sip:10000@172.16.130.42>";                           alertName=huntpilotname
//huntpiloturi = "huntpilotname”<sip:10000@172.16.130.42>;                           alertName=huntpilotname
//huntpiloturi = "%22huntpilotname%22<sip:10000@172.16.130.42>";            alertName=huntpilotname
//huntpiloturi = "%22huntpilot%22name%22"<sip:10000@172.16.130.42>;     alertName=huntpilot%22name
//输入描述:
//String with URI information
//输出描述:
//String
//输入例子1:
//"Cisco"
//输出例子1:
//Cisco
//输入例子2:
//"%22Cisco%22"
//输出例子2:
//Cisco
public class protocal_data_parse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Pattern pattern = Pattern.compile("\"*(%22)?(\\w+(%22)*\\w+)(%22)?\"*(<\\w+:\\w+@\\w+.\\w+.\\w+.\\w+>)*\"*");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}
