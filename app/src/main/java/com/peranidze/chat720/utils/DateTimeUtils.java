package com.peranidze.chat720.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static boolean isSameDays(Long timestamp, Long timestampOther) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(new Date(timestamp)).equals(fmt.format(new Date(timestampOther)));
    }
}
