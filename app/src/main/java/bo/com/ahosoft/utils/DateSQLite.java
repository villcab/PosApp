package bo.com.ahosoft.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by villcab on 30-12-16.
 */

public class DateSQLite {

    private static final SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");

    public static String nowDate() {
        return formatterDate.format(new Date());
    }

    public static String formatDate(Date date) {
        return formatterDate.format(date);
    }
}
