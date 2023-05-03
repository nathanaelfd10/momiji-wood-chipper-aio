package com.noxfl.momiji.woodchipper.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils {

    public static String getCurrentUtcDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentUtcTime = Date.from(Instant.now());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        return simpleDateFormat.format(currentUtcTime);
    }

}
