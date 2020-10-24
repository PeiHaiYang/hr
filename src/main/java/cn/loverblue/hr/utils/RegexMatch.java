package cn.loverblue.hr.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author PHY
 * @date 2020-10-09$-10:12
 */
public class RegexMatch {
    private static String regex = "\\w+@(\\w+.)+[a-z]{2,3}";

    public static List<String> getString(String s) {
        List<String> strs = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()) {
            strs.add(m.group());
        }
        return strs;
    }

    public static boolean isLegalInputLine(String line) {
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        Matcher isNum = pattern.matcher(line);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}