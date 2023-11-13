package christmas.service;

import static christmas.enums.EventName.WEEKDAY;
import static christmas.enums.EventName.WEEKEND;

public class GetDayOfTheWeek {
    public static String getDayOfTheWeek(int visitDate) {
        if(visitDate % 7 == 1 || visitDate % 7 == 2) {
            return WEEKEND.getEventName();
        }
        return WEEKDAY.getEventName();
    }
}
