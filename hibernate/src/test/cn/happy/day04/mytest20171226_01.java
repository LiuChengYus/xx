package cn.happy.day04;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by CY on 2017/12/26.
 */
public class mytest20171226_01 {
    @Test
    public void t1() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(sdf.parse("2017-11-11"));
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf1.parse("2017-11-11"));
    }
}
