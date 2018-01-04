package cn.happy.day03.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CY on 2017/12/26.
 */
public class Tool {
    public static Date setToData(String data) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         return sdf.parse(data);
    }
}
