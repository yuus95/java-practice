package ch10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class LocalDateTimeex1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022, 12, 12);
        LocalTime time = LocalTime.of(12, 34, 56);

        // date && time to LocalDateTime
        LocalDateTime dt = LocalDateTime.of(date,time);
        LocalDateTime dt1 = date.atTime(time);
        LocalDateTime dt2 = time.atDate(date);
        LocalDateTime dt3 = date.atTime(12, 34, 56);
        LocalDateTime dt4 = time.atDate(LocalDate.of(2015, 12, 31));
        LocalDateTime dt5 = date.atStartOfDay();

        List<LocalDateTime> dt6 = List.of(dt, dt1, dt2, dt3, dt4, dt5);

        dt6.forEach(System.out::println);

//        LocalDateTime -> LocalDate || LocalTime



    }
}
