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
    public static List<String> getString(String s, String regex) {
        List<String> strs = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()) {
            strs.add(m.group());
        }
        return strs;
    }

    public static boolean isLegalInputLine(String line) {
        Pattern p = Pattern.compile("/^@$/");
        Matcher m = p.matcher(line);
        boolean r = m.matches();

        return r;
    }
}