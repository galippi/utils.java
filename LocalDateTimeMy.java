package lippiWare.utils;

import java.util.Date;

public class LocalDateTimeMy {
    public LocalDateTimeMy()
    {
        date = new Date();
    }

    LocalDateTimeMy(int year, int month, int day, int hrs, int min, int sec)
    {
        date = new Date(year - 1900, month - 1, day, hrs, min, sec);
    }

    static public LocalDateTimeMy of(int year, int month, int day, int hrs, int min, int sec)
    {
        return new LocalDateTimeMy(year, month, day, hrs, min, sec);
    }

    static public LocalDateTimeMy now()
    {
        return new LocalDateTimeMy();
    }

    public int getDayOfWeek() {
        return date.getDay();
    }

    public String getDayOfWeekString() {
        int day = date.getDay();
        switch (day)
        {
            case 0:
                return "Sun";
            case 1:
                return "Mon";
            case 2:
                return "Tue";
            case 3:
                return "Wed";
            case 4:
                return "Thu";
            case 5:
                return "Fri";
            default:
                return "Sat";
        }
    }

    public int getMonthValue() {
        return date.getMonth() + 1;
    }

    public String getMonthValueString() {
        int month = getMonthValue();
        switch (month)
        {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            default:
                return "Dec";
        }
    }

    public int getDayOfMonth() {
        return date.getDate();
    }

    public int getHour() {
        return date.getHours();
    }

    public int getMinute() {
        return date.getMinutes();
    }

    public int getSecond() {
        return date.getSeconds();
    }

    public int getYear() {
        return date.getYear() + 1900;
    }

    Date date;
}
