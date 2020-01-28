/**
 * 1185. Day of the Week
 * https://leetcode.com/problems/day-of-the-week/
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOfTheWeek {
    public static void main(String args[]) {
        System.out.println(dayOfTheWeek(1, 1, 2020));
    }

    static String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static String dayOfTheWeek(int day, int month, int year) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        Date nDate = null;
        try {
            nDate = dateFormat.parse(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(nDate);
        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;

//        System.out.println(dayNum);

        return dayName[dayNum-1];
    }
}

// other solution... (calcuate directly)
// https://leetcode.com/problems/day-of-the-week/discuss/377384/JavaC%2B%2BPython-Zeller-Formula
//    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//    public String dayOfTheWeek(int d, int m, int y) {
//        if (m < 3) {
//            m += 12;
//            y -= 1;
//        }
//        int c = y / 100;
//        y = y % 100;
//        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
//        return days[(w + 7) % 7];
//    }