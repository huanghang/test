package com.isoftstone.demo.kit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 日期格式化工具包，避免大量新建SimpleDateFormat
 *
 */
public class DateFormatKit {
    private static ConcurrentHashMap<String, SimpleDateFormat> dateFormats = new ConcurrentHashMap<>();

    public static SimpleDateFormat getDateFormat(String pattern) {
        if (!dateFormats.containsKey(pattern)) {
            dateFormats.putIfAbsent(pattern, new SimpleDateFormat(pattern));
        }
        return dateFormats.get(pattern);
    }

    /**
     * 字符串转为日期
     *
     * @param string  字符串
     * @param pattern 格式
     * @return 日期
     * @throws ParseException 无法转换时，抛出
     */
    public static Date toDate(String string, String pattern) throws ParseException {
        return getDateFormat(pattern).parse(string);
    }

    /**
     * 日期转为字符串
     *
     * @param date    日期
     * @param pattern 格式
     * @return 字符串
     */
    public static String toString(Date date, String pattern) {
        return getDateFormat(pattern).format(date);
    }

}
