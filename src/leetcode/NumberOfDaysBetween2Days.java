package leetcode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NumberOfDaysBetween2Days {

    public int daysBetweenDates(String date1, String date2) {
        LocalDate date_before = LocalDate.parse(date1);
        LocalDate date_after = LocalDate.parse(date2);

        //calculate number of days between them
        long result = ChronoUnit.DAYS.between(date_before, date_after);

        return Math.abs((int)result);
    }

}