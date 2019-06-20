package com.zx.office.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeProcess {
    private TimeProcess(){}

    public static String getYear(){
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String getPreYear(){
        return TimeProcess.getYear().substring(2);
    }
}
