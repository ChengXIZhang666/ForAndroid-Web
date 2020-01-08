package Tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDate() {
        Date date1 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(date1);
        return date;
    }
}