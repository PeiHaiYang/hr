package cn.loverblue.hr.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author PHY
 * @date 2020-09-29$-20:26
 */
@Component
public class ConvertData implements Converter<String, Date> {

    private static String formats = "yyyy-MM-dd";

    private static SimpleDateFormat format = new SimpleDateFormat(formats);
    @Override
    public Date convert(String s) {
        Date parse = null;
        try {
            parse = format.parse(s);
            long time = parse.getTime();
            java.sql.Date date = new java.sql.Date(time);
            System.out.println(date);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }


    }



}
