package bo.com.ahosoft.utils;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MyDateUtils {

    private static TimeZone timeZone = TimeZone.getTimeZone("GMT-4");

    public static Long now() {
        GregorianCalendar c = new GregorianCalendar(timeZone);
        return c.getTimeInMillis();
    }
}
