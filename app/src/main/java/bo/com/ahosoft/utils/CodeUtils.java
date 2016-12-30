package bo.com.ahosoft.utils;

import java.util.UUID;

public class CodeUtils {

    public static String generateGuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
