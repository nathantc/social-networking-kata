import java.util.Calendar;

public class SystemCalendar {
    private static Calendar calendar;

    static {
        calendar = Calendar.getInstance();
    }

    public static void override(Calendar calendar) {
        SystemCalendar.calendar = calendar;
    }

    public static Calendar getInstance() {
        return calendar;
    }

    public static long currentTimeMillis() {
        return calendar.getTimeInMillis();
    }
}
