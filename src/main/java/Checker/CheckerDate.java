package Checker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CheckerDate {




    public boolean check_date(String Date, int late)
    {
        int end = Date.indexOf(',');
        int day;
        int month;
        int year;
        String date = Date.substring(0,end);
        try {
            day = Integer.parseInt(date.substring(0, 2));
            month = checkMounth(date.substring(3,end  - 5));

        }
        catch (RuntimeException e)
        {
            day = Integer.parseInt(date.substring(0, 1));
            month = checkMounth(date.substring(2,end  - 5));

        }
        year = Integer.parseInt(date.substring(end-4, end));
        Calendar c = new GregorianCalendar();

        c.add(Calendar.DAY_OF_YEAR, -late);

        Calendar next = new GregorianCalendar(year,month-1,day);



        return  (c.after(next));

    }

    private int checkMounth(String  month)
    {

        int MonthInt = 0;
        if (month.equals("января")) {
            MonthInt = 1;

        } else if (month.equals("февраля")) {
            MonthInt = 2;

        } else if (month.equals("марта")) {
            MonthInt = 3;

        } else if (month.equals("апреля")) {
            MonthInt = 4;

        } else if (month.equals("мая")) {
            MonthInt = 5;

        } else if (month.equals("июня")) {
            MonthInt = 6;

        } else if (month.equals("июля")) {
            MonthInt = 7;

        } else if (month.equals("августа")) {
            MonthInt = 8;

        } else if (month.equals("сентября")) {
            MonthInt = 9;

        } else if (month.equals("октября")) {
            MonthInt = 10;

        } else if (month.equals("ноября")) {
            MonthInt = 11;

        } else if (month.equals("декабря")) {
            MonthInt = 12;

        }

        return  MonthInt;
    }



}
