package Start.Tregulov.p6_REGex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        int len = 0;
        int dlina = 0;
        String str1 = "";
        String s = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,yandex";
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\w+[(\\s{0,1})|(,{0,1})]{0,1})");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            if (len < matcher.group().length()) len = matcher.group().length();
            list1.add((matcher.group()).trim());
        }
        len *= 3;
        for (String str : list1) {
            dlina += str.length() + 1;
            if (dlina <= len + 1) {
                str1 = str1.concat(str) + " ";
            } else {
                list2.add(str1.trim());
                str1 = str + " ";
                dlina = str1.length();
            }
        }
        if (!str1.equals("")) list2.add(str1.trim());

        for (String e : list2) {
            System.out.println(e);
        }
    }
}