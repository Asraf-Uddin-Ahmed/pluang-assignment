package com.pluang.utils;

import java.util.Date;

public final class DateUtil {
    private DateUtil() {
    }

    public static Long getEpochIfExists(Date date) {
        return date == null ? null : date.getTime();
    }
}
