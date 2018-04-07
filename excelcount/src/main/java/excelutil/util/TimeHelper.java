package excelutil.util;

import excelutil.constant.DateFormatType;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 简单的日期/时间工具类
 * 完成对bean中时间类型的解析和传入
 */
public class TimeHelper {

    //检测类型用
    private static Date date = new Date();
    //检测类型用
    private static Timestamp timestamp = new Timestamp(date.getTime());

    public static DateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static DateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }


    public static String dataToString(Date date, DateFormat dateFormat) {
        if (date == null) return "";
        return dateFormat.format(date);
    }


    public static String dateToString(Date date) {
        if (date == null) return "";
        return defaultDateFormat.format(date);
    }

    public static String dateToString(Object date, String dateFormat) {
        String dateString = null;
        if (StringHelper.isBlank(dateFormat)) dateFormat = DateFormatType.YAER_DATE_TIME.getDateFormatString();
        try {
            dateString = dataToString((Date) date, getDateFormat(dateFormat));
        } catch (Exception e) {
            try {
                dateString = dataToString((new Date(((Timestamp) date).getTime())), getDateFormat(dateFormat));
            } catch (Exception ignored) {
            }
        }
        return dateString;
    }

    /**
     * 判断是否为时间类型
     * 目前支持Date和Timestamp
     * @param type
     * @return
     */
    public static boolean isDateType(Class<?> type) {
        return type.isInstance(date) || type.isInstance(timestamp);
    }

}
