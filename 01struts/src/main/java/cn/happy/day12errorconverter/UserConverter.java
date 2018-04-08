package cn.happy.day12errorconverter;
import org.apache.struts2.util.StrutsTypeConverter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by CY on 2018/2/27.
 */
public class DateConverter extends StrutsTypeConverter {
    DateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
    public Object convertFromString(Map context, String[] values, Class toClass) {
        System.out.println("砖汉"+values[3]);
      return null;
    }

    public String convertToString(Map context, Object o) {
        System.out.println("转换,,,,,");
        return null;
    }
}
